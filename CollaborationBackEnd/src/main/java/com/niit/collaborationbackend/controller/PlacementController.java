package com.niit.collaborationbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
return new ResponseEntity(placementDAO.getAllPlacements(), HttpStatus.OK);
}




@RequestMapping(value="placement/delete/{p_id}",method=RequestMethod.DELETE)
public ResponseEntity<?> deletePlacement(@PathVariable int p_id)
{
	Placement placement = placementDAO.getPlacementByPlacementId(p_id);
	System.out.println("delete mapping with id :" + p_id);
	placementDAO.deletePlacement(placement);
	System.out.println("placement deleted : " + placement );
	return new ResponseEntity("DELETED", HttpStatus.OK);
}


@RequestMapping(value="placement/edit" ,method=RequestMethod.POST,consumes="application/json",produces="application/json")
public ResponseEntity<?> updatePlacement(@RequestBody Placement placement)
{
	System.out.println("in placement edit rest controller with placement object :" + placement);
	if ( placement == null)
	{
		return new ResponseEntity("No placement found for this id :" + placement.getP_id(),HttpStatus.NOT_FOUND);
	}
	placement = placementDAO.updatePlacement(placement.getP_id(), placement);
return new ResponseEntity(placement , HttpStatus.OK);	
}
}