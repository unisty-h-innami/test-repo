package controllers;

import java.util.List;

import models.DBAccessModel;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.datainsert;
import views.html.datalist;



/**
*
* <p>Applicationを操作するControllerクラス</p>
*
*
*/
public class ApplicationController extends Controller{


    /**
     *
     *<p>データ登録画面を呼び出すメソッド</p>
     *
     * @return データ登録画面
     */
    public static Result index(){
        return ok(datainsert.render());

    }

    /**
     *
     * <p>DBAccessModelのinsertメソッドを呼び出すメソッド</p>
     *
     *@return 登録データ表示画面
     */
    public static Result insert() {
        try{
            DBAccessModel.insert();
        }catch(Exception e){
            Logger.error("データ登録失敗　"+e.getMessage());
            return redirect(routes.ApplicationController.getList());
        }
        Logger.info("insert success");
        return redirect(routes.ApplicationController.getList());
    }

    /**
    *
    *<p>DBAccessModelのgetRecodeからListを受け取るメソッド</p>
    *
    *@return 登録データ表示画面
    */
    public static Result getList() {
        List<DBAccessModel> list = DBAccessModel.getRecode();
        return ok(datalist.render(list));

    }

    /**
     *<p>DBAccessModelのgetRecodeからidの降順に並び替えたListを受け取るメソッド</p>
     *
     *@return 登録データ表示画面
     */
    public static Result getListIdDesc() {
        List<DBAccessModel> desclist = DBAccessModel.getIdDesc();
        return ok(datalist.render(desclist));

    }

}
