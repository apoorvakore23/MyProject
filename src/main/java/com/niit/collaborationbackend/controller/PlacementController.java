package com.niit.collaborationbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaborationbackend.dao.PlacementDAO;
import com.niit.collaborationbackend.model.Placement;

@RestController
public class PlacementController {
@Autowired
private PlacementDAO placementDAO;


@GetMapping("placements")
public ResponseEntity<List<Placement>> getPlacements()
{
	System.out.println(placementDAO.getAllPlacements());
return new ResponseEntity(placementDAO.getAllPlacements(),HttpStatus.OK);	
}


@GetMapping("placement/{id}")
public ResponseEntity<?> getPlacement(@PathVariable("id") int id)
{	
Placement placement = placementDAO.getPlacementByPlacementId(id);


if (placement == null)
{
	return new ResponseEntity("No placement found for id " + id, HttpStatus.NOT_FOUND);
}
System.out.println(placement);
return new ResponseEntity(placement.toString(), HttpStatus.OK);
}



@RequestMapping(value="placement/create", method=RequestMethod.POST,consumes="application/json",produces="application/json")
public ResponseEntity<?> createPlacement(@RequestBody  Placement placement)
{
placementDAO.addPlacement(placement);
System.out.println("placement added : " + placement);
return new ResponseEntity("hi", HttpStatus.OK);
}



//
//@RequestMapping(value="placement/delete",method=RequestMethod.DELETE, consumes="application/json",produces="application/json")
//public ResponseEntity<?> deletePlacement(@RequestBody int placementId,  @RequestBody Placement placement)
//{
//	placement = placementDAO.getPlacementByPlacementId(placementId);
//	System.out.println("delete mapping with id :" + placementId);
//	placementDAO.deletePlacement(placement);
//	System.out.println("placement deleted : " + placement );
//	return new ResponseEntity("DELETED", HttpStatus.OK);
//}
//
//
//@RequestMapping(value="placement/edit" ,method={RequestMethod.PUT,RequestMethod.GET},consumes="application/json",produces="application/json")
//public ResponseEntity<?> updatePlacement(@RequestBody int placementid,@RequestBody Placement placement)
//{
//	if ( placement == null)
//	{
//		return new ResponseEntity("No placement found for this id :" + placementid,HttpStatus.NOT_FOUND);
//	}
//	placement = placementDAO.updatePlacement(placementid, placement);
//return new ResponseEntity(placement , HttpStatus.OK);	
//}
}