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
@RequestMapping(path="/sql/blog") // All API paths start with '/sql/blog'
@ConditionalOnProperty(name="disablemysql", havingValue="false", matchIfMissing=true)
public class BlogController extends SqlObjController<Blog,BlogRepository> {
  /**
   * Add a blog
   * 
   * @param  name    name of blog
   * @param  userid  the user id of the blog author
   * @param  tags    tags that the blog are given
   * @param  date    date that the blog was published
   */
  @PostMapping(path="/add")
  public @ResponseBody void add(@RequestParam(required=true)  String name,
                                @RequestParam(required=true)  String userid,
                                @RequestParam(required=false) String tags,
                                @RequestParam(required=true) String date) {

    Blog a = new Blog();

    a.setName(name);
    a.setUserId(userid);
    a.setTags(tags);
    a.setDate(date);

    super.repo.save(a);
  }

  /**
   * Update a blog
   * 
   * @param  id      id of the blog to be updated
   * @param  name    the updated name of blog
   * @param  userid  the updated user id of blog author
   * @param  tags    the updated tags of blog
   * @param  date    the updated date the blog was published
   */
  @PostMapping(path="/update")
  public @ResponseBody void update(@RequestParam(required=true)   String id,
                                   @RequestParam(required=false)  String name,
                                   @RequestParam(required=false)  String userid,
                                   @RequestParam(required=false)  String tags,
                                   @RequestParam(required=false)  String date) {

    Blog a = getId(id).get();

    a.setName(name);
    a.setUserId(userid);
    a.setTags(tags);
    a.setDate(date);

    super.repo.save(a);
  }
}

