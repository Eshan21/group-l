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

/**
 * API for mysql database
 */
@Controller
@RequestMapping(path="/sql") // All API paths start with '/sql'
public class MainController {
  @Autowired
  private UserRepository userRepository;

  /**
   * Adds a user
   * 
   * @param  name  name of created user
   * @param  email email of created user
   */
  @PostMapping(path="/add")
  public @ResponseBody void addNewUser (@RequestParam(required=true) String name
      , @RequestParam(required=true) String email) {

    User n = new User();
    n.setName(name);
    n.setEmail(email);
    userRepository.save(n);
  }

  /**
   * Removes a user by id
   * 
   * @param  id  Id of user to remove
   */
  @PostMapping(path="/removeId")
  public @ResponseBody void removeUserById (@RequestParam(required=true) String idstr) {
      int id = Integer.parseInt(idstr);
      userRepository.deleteById(id);
  }

  /**
   * Removes all users
   */
  @PostMapping(path="/removeAll")
  public @ResponseBody void removeAllUsers() {
    userRepository.deleteAll();
  }

  /**
   * Gets a user by id
   * 
   * @param  id  id of user to get
   * @return     returns the user if it exists, otherwise return null
   */
  @GetMapping(path="/getId")
  public @ResponseBody Optional<com.groupl.mysql.User> getId(String idstr) {
      int id = Integer.parseInt(idstr);
      return userRepository.findById(id);
  }

  /**
   * Gets all users
   * 
   * @return  returns all users in the database
   */
  @GetMapping(path="/getAll")
  public @ResponseBody Iterable<User> getAllUsers() {
    // This returns a JSON or XML with the users
    return userRepository.findAll();
  }
}

