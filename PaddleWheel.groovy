float wheelRadius = 75
float wheelHeight = 50
int releaseAngle = 10
int wallThickness = 2
tollerance = 0
CSG m5Bearing = Vitamins.get("ballBearing", "695zz")
CSG bearingCylinder = new Cylinder(m5Bearing.getMaxY() + tollerance, m5Bearing.getMaxY() + tollerance,5,(int)30).toCSG()

CSG base = new Cylinder(wheelRadius-wallThickness,wheelRadius-wallThickness,5,(int)30).toCSG()
CSG innerVoid = base.scalez(10)
CSG outerWall = new Cylinder(wheelRadius,wheelRadius,50,(int)70).toCSG().difference(innerVoid)//convert to CSG to display                    			         ).toCSG()//convert to CSG to display 
CSG scoopInner = new Cylinder(10,10,wheelHeight+5,(int)30).toCSG()
CSG scoopOuter = new Cylinder(12,12,wheelHeight+5,(int)30).toCSG()
CSG cutPlane = new Cube(40,20,60).toCSG().movey(-10).toZMin()
CSG scoopCombined = scoopOuter.difference(scoopInner).difference(cutPlane).rotz(releaseAngle).rotx(-10).roty(-3).movex(wheelRadius-12)
CSG wheel = base.union(outerWall)
for(int i=0; i<8; i++){
	wheel=wheel.union(scoopCombined.rotz(i*(360/8)))
}
wheel=wheel.intersect(new Cylinder(wheelRadius,wheelRadius,wheelHeight,(int)70).toCSG())

CSG bearingSupport = new Cylinder(15,10,15,(int)30).toCSG()
wheel = wheel.union(bearingSupport)
wheel = wheel.difference(bearingCylinder.movez(10))
wheel = wheel.difference(bearingCylinder)
wheel = wheel.difference(new Cylinder(2.5 + tollerance,2.5 + tollerance,20,(int)30).toCSG())
return wheel