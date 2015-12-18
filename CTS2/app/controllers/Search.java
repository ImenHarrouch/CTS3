package controllers;

import models.Tool;
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

        //  if(search.trim().length() == 0 && cat.equals("")){
        //  List<ToolCategory> toolcat = ToolCategory.find.all();
        List<Tool> tool = Tool.find.where().eq("category",cat).findList();
        //   return redirect(routes.Website.tools());
        return ok(views.html.cts.tools.render(tool));


        //    }
        //   return ok();
    }

    public Result viewcomment(Long id){
        Tool tool = Tool.find.where().idEq(id).findUnique();
        if(tool==null){
            flash("No comments");
            return ok(views.html.cts.buy.render(tool));
        }
        else
            return ok(views.html.cts.buy.render(tool));


    }
}
