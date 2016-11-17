package com.niit.collaborationbackend.dao;
import java.util.List;

import com.niit.collaborationbackend.model.Placement;
public interface PlacementDAO {
	
		public void addPlacement(Placement u);
		public Placement getPlacementByPlacementId(int id);
		 public List<Placement> getAllPlacements();
		 public Placement getPlacementByPlacementname (String Title);
	}
