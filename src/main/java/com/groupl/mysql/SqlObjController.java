package com.groupl.mysql;

import java.lang.Integer;
import java.util.Optional;
import javax.persistence.MappedSuperclass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
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
@MappedSuperclass
public abstract class SqlObjController<T,E extends CrudRepository> {

    @Autowired
    protected E repo;

    /**
     * Removes a row by id
     *
     * @param  id  Id of row to remove
     */
    @PostMapping(path="/removeId")
    public @ResponseBody void removeId(@RequestParam(required=true) String id) {
            int x = Integer.parseInt(id);
            repo.deleteById(x);
    }

    /**
     * Removes all rows
     */
    @PostMapping(path="/removeAll")
    public @ResponseBody void removeAll() {
        repo.deleteAll();
    }

    /**
     * Gets a row by id
     * 
     * @param  id  id of user to get
     * @return     returns the rows if it exists, otherwise return null
     */
    @GetMapping(path="/getId")
    public @ResponseBody Optional<T> getId(String id) {
        int x = Integer.parseInt(id);
        return repo.findById(x);
    }

    /**
     * Gets all rows
     * 
     * @return    returns all rows in the database
     */
    @GetMapping(path="/getAll")
    public @ResponseBody Iterable<T> getAll() {
        // This returns a JSON or XML with the users
        return repo.findAll();
    }
}

