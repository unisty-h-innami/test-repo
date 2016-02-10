package views;

import static org.fest.assertions.Assertions.*;
import static play.test.Helpers.*;

import java.util.List;

import models.DBAccessModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import views.html.datalist;
import controllers.routes;

public class DataListTest {

    @Before
    public void setup(){
        start(fakeApplication(inMemoryDatabase()));
    }

    @Test
    public void test() {
        List<DBAccessModel> num = DBAccessModel.find.findList();

        String a = routes.ApplicationController.getList().toString();
        String b = routes.ApplicationController.getListIdDesc().toString();
        String c = routes.ApplicationController.index().toString();

        String htmlString = play.test.Helpers.contentAsString(datalist.render(num));
        assertThat(htmlString).contains("<button type=\"submit\" onclick=\"location.href='"+a+"'\">昇順</button>");
        assertThat(htmlString).contains("<button type=\"submit\" onclick=\"location.href='"+b+"'\">降順</button>");
        assertThat(htmlString).contains("<button type=\"button\" onclick=\"location.href='"+c+"'\">戻る</button>");
    }

    @After
    public void end() {
        stop(fakeApplication());
    }
}
