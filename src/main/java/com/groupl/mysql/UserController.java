package com.groupl.mysql;

import java.lang.Integer;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

/**
 * API for mysql database
 */
@Controller
@RequestMapping(path="/sql/user") // All API paths start with '/sql/user'
@ConditionalOnProperty(name="disablemysql", havingValue="false", matchIfMissing=true)
public class UserController extends SqlObjController<User,UserRepository> {

    /**
     * Adds a user
     * 
     * @param  name  username of created user
     * @param  fname  first name of created user
     * @param  lname  last name of created user
     * @param  email email of created user
     */
    @PostMapping(path="/add")
    public @ResponseBody void add(@RequestParam(required=true)  String name,
                                  @RequestParam(required=false) String fname,
                                  @RequestParam(required=false) String lname,
                                  @RequestParam(required=true)  String email) {

      User a = new User(name, fname, lname, email);
      super.repo.save(a);
    }

    /**
     * Updates the user's information
     *
     * @param  id     The id of the user to be updated
     * @param  name   The updated name of the user
     * @param  fname  The updated fname of the user
     * @param  lname  The updated lname of the user
     * @param  email  The updated email of the user
     */
    @PostMapping(path="/update")
    public @ResponseBody void update(@RequestParam(required=true)  String id,
                                  @RequestParam(required=false)  String name,
                                  @RequestParam(required=false) String fname,
                                  @RequestParam(required=false) String lname,
                                  @RequestParam(required=false)  String email) {

      User a = getId(id).get();

      if (a == null) {
          System.out.println("Invalid ID");
          return;
      }

      a.setId(Integer.parseInt(id));
      
      if (name != null) {
          a.setName(name);
      }

      if (fname != null) {
          a.setFname(fname);
      }

      if (lname != null) {
          a.setLname(lname);
      }

      if (email != null) {
          a.setEmail(email);
      }

      super.repo.save(a);
    }
}

