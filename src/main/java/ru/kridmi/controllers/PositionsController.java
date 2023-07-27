package ru.kridmi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kridmi.dao.PositionDao;
import ru.kridmi.models.Position;

import java.util.List;

@RestController
@RequestMapping("api/positions")
public class PositionsController {
    private final PositionDao positionDao;

    @Autowired
    public PositionsController(PositionDao positionDao) {
        this.positionDao = positionDao;
    }

    @GetMapping()
    public List<Position> showAll() {
        return positionDao.showAll();
    }

    @GetMapping("/{id}")
    public Position showEmp(@PathVariable("id") int id) {
        return positionDao.show(id);
    }


    @PostMapping
    public List<Position> create(@RequestBody Position position) {
        positionDao.create(position);
        return positionDao.showAll();
    }

    @PatchMapping("/{id}")
    public Position update(@RequestBody Position position, @PathVariable("id") int id) {
        positionDao.update(position, id);
        return positionDao.show(id);
    }

    @DeleteMapping("/{id}")
    public List<Position> delete(@PathVariable("id") int id) {
        positionDao.delete(id);
        return positionDao.showAll();
    }

    @GetMapping("/search/{position}")
    public List<Position> showPos(@PathVariable("position") String position) {
        return positionDao.showPos(position);
    }

}
