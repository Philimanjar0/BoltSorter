import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.neuronrobotics.bowlerstudio.vitamins.Vitamins

import eu.mihosoft.vrl.v3d.CSG
import eu.mihosoft.vrl.v3d.FileUtil

import java.lang.reflect.Type;

String WHEEL_FILE = "/home/phil/Project_Parts/BoltSorter/Wheel/"
File file = new File(WHEEL_FILE + "wheel.stl")
CSG thing = Vitamins.get(file)

return thing