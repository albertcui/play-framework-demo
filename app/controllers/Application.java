/*
See https://www.playframework.com/documentation/2.0/JavaActions
*/

package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public Result potato() {
        return ok(potato_view.render());
    }

}
