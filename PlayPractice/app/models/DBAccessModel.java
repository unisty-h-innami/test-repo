package models;




import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.Form;
import play.db.ebean.Model;

@Entity

public class DBAccessModel extends Model {

    /**  idを定数として保持 */
    public static final String ID = "id";

    /** ID */
    @Id
    @Column(nullable = false)
    public  Integer id;

    /** カラム1 */
    @Column(length = 10, nullable = true)
    public String columnOne;

    public static final Finder<Long,DBAccessModel> find = new Finder<Long,DBAccessModel>(Long.class, DBAccessModel.class);

    /**
     * <p>DBにデータを登録するメソッド</p>
     *
     * @param insert　form入力された値
     * @return DBAccessModelの検索結果
     *
     */
    public static DBAccessModel insert() {

        DBAccessModel insert = Form.form(DBAccessModel.class).bindFromRequest().get();
        insert.save();
        return insert;
    }

    /**
     * <p>DBのデータをListにするメソッド</p>
     *
     * @param list DBAccessModelの検索結果
     * @return List<DBAccessModel>
     */
    public static List<DBAccessModel> getRecode(){

        List<DBAccessModel> list = DBAccessModel.find.all();
        return list;
    }

    /**
     * <p>DBのデータをidの降順に並び替えてListにするメソッド</p>
     *
     * @param list2 idの降順に並び替えたDBAccessModelの検索結果
     * @return List<DBAccessModel>
     */
    public static List<DBAccessModel> getIdDesc(){

        List<DBAccessModel> list2 = DBAccessModel.find.where()
                .orderBy().desc(ID)
                .findList();
        return list2;
    }

}
