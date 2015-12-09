package controllers;

import models.Tool;
import models.ToolCategory;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

import static play.data.Form.form;

public class Search extends Controller{

    public Result search(){

        DynamicForm form = form().bindFromRequest();
        String search = form.data().get("search");
        String cat = form.data().get("categories");

        if(search.trim().length() == 0 && cat.equals("")){
            List<ToolCategory> toolcat = ToolCategory.find.all();
            List<Tool> tool = Tool.find.where().findList();
            return ok(String.valueOf(routes.Website.tools()));


        }
        return ok();
    }
}
