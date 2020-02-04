float wheelRadius = 75
float wheelHeight = 50
int releaseAngle = 10
CSG base = new Cylinder(wheelRadius-3,wheelRadius-3,5,(int)30).toCSG()
CSG innerVoid = base.scalez(10)
CSG outerWall = new Cylinder(wheelRadius,wheelRadius,50,(int)30).toCSG().difference(innerVoid)//convert to CSG to display                    			         ).toCSG()//convert to CSG to display 
CSG scoopInner = new Cylinder(9,9,wheelHeight+5,(int)30).toCSG()
CSG scoopOuter = new Cylinder(12,12,wheelHeight+5,(int)30).toCSG()
CSG cutPlane = new Cube(40,20,60).toCSG().movey(-10).toZMin()
CSG scoopCombined = scoopOuter.difference(scoopInner).difference(cutPlane).rotz(releaseAngle).rotx(-10).roty(-3).movex(wheelRadius-13)
CSG wheel = base.union(outerWall)
innerVoid = innerVoid.scalex(0.5).scaley(0.5)
CSG cleanMax = new Cylinder(wheelRadius,wheelRadius,wheelHeight,(int)30).toCSG()

for(int i=0; i<8; i++){
	wheel=wheel.union(scoopCombined.rotz(i*(360/8)))
}
wheel=wheel.difference(innerVoid)
wheel=wheel.intersect(cleanMax)
return wheel