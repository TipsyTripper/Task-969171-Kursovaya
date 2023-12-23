package database.persistence;

import database.database.MyDataBase;

import java.util.Map;

public class OptionsPersistence extends  Thread{

    private final MyDataBase db = MyDataBase.getInstance();
    private static final String NIK_NAME = "name";
    private static final String BOLT_NAME = "bolt";
    private static final String GAMBLERS_NAME = "gamblers";
    private static final String ID_NAME = "id";

    public void createGambler(String name, int count_of_gamblers_in_game, int bolt) {
        String sql = """
                    insert into dice.gamblers
                    (name, gamblers, bolt)
                    values
                    ('%s', %d, %d)
                    """;
        db.execute(String.format(sql, name, count_of_gamblers_in_game, bolt));
    }

    public void updateInf(int id, String column, String other) {
        String sql = """
                    update dice.gamblers
                    set %s = %s
                    where id = %d
                    """;
        String update = String.format(sql, column, other, id);

        db.execute(update);
    }

    public int selectIdByName(String name) {
        int fromDB = db.selectSomeColumnByName(
                name,
                ID_NAME
        );
        if (fromDB == 0) {
            return 0;
        }

        return fromDB;
    }

    public int selectGamblersById(int id) {
        int fromDB = db.selectColumnById(
                id,
                GAMBLERS_NAME
        );
        if (fromDB == 0) {
            return 0;
        }

        return fromDB;
    }

    public int selectBoltById(int id) {
        int fromDB = db.selectColumnById(
                id,
                BOLT_NAME
        );
        if (fromDB == 0) {
            return 0;
        }

        return fromDB;
    }

    public String selectNameById(int id) {
        String fromDB = db.selectNameById(
                id,
                NIK_NAME
        );
        if (fromDB == null) {
            return null;
        }

        return fromDB;
    }

    public Map<Integer, String> getAll() {
        Map<Integer, String> fromDB = db.selectAll(
                NIK_NAME,
                BOLT_NAME,
                GAMBLERS_NAME
        );

        return fromDB;
    }
}