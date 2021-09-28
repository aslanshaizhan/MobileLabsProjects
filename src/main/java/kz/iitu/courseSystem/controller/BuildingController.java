package kz.iitu.courseSystem.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import kz.iitu.courseSystem.entities.Building;
import kz.iitu.courseSystem.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/building")
public class BuildingController {

    @Autowired
    private BuildingRepository buildingRepository;

    @ApiOperation(value = "List of all building")
    @GetMapping("/list")
    public List<Building> buildingsList(){
        return buildingRepository.findAll();
    }

    @PostMapping("")
    public void newBuilding(@RequestBody Building building){
        buildingRepository.save(building);
    }

    @PostMapping("/update")
    public void updateBuilding(@RequestBody Building building){
        buildingRepository.save(building);
    }

    @ApiOperation(value = "Update building name")
    @PatchMapping("/{id}/name")
    public void updateBuildingName(@PathVariable Long id,
                                     @RequestParam String name){
        if (id == null || name.equals("")){
            throw new RuntimeException("id and location should not be empty");
        }
        Building building = buildingRepository.findById(id).get();
        building.setName(name);
        buildingRepository.save(building);
    }

}
