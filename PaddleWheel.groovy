CSG simpleSyntax =new Cylinder(10,40).toCSG() // a one line Cylinder
CSG myCylinder = new Cylinder(100, // Radius at the bottom
                      		100, // Radius at the top
                      		5, // Height
                      		(int)30 //resolution
                      		).toCSG()
                      		//convert to CSG to display                    			         ).toCSG()//convert to CSG to display 
CSG scoopInner = new Cylinder(10,10,50,(int)30).toCSG()
CSG scoopOuter = new Cylinder(12,12,50,(int)30).toCSG()
CSG cutPlane = new Cube(40,20,60).toCSG().movey(-10)
CSG scoopCombined = scoopOuter.difference(scoopInner).rotx(-10)
return cutPlane//Your code here