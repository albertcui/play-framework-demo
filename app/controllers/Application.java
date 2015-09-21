/*
See https://www.playframework.com/documentation/2.0/JavaActions
*/

package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import play.db.ebean.*;
import java.util.*;

import views.html.*;
import models.*;

public class Application extends Controller {

    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public Result potato() {
        return ok(potato_view.render());
    }
    
    public Result dynamic(String name) {
        return ok(a_dynamic_page.render(name));
    }
    
    public Result toDo() {
        
        List<ToDo> toDoList;
        try {
            toDoList = ToDo.find.all();
        } catch (Exception e) {
            toDoList = new LinkedList<ToDo>();
        }
        
        Form<ToDo> toDoForm = Form.form(ToDo.class);
        return ok(todo.render(toDoForm, toDoList));
    }
    
    public Result submit() {
        DynamicForm toDoForm = new DynamicForm();
        
        toDoForm = toDoForm.bindFromRequest(); //forms are immutable

        if (toDoForm.hasErrors()) {
            return badRequest("Uh oh");
        } else {
            
            (new ToDo(toDoForm.get("description"), toDoForm.get("done") != null ? true : false))
                .save();
                
            return redirect("/todo");
        }
    }
}
