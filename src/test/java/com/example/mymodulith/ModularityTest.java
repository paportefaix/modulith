package com.example.mymodulith;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

public class ModularityTest {

  @Test
  public void applicationModules() {
    ApplicationModules modules = ApplicationModules.of(MymodulithApplication.class);
    modules.forEach(System.out::println);
    modules.verify();
  }

  @Test
  void generateModuleDiagram() {
    ApplicationModules modules = ApplicationModules.of("com.example.mymodulith");
    modules.verify(); // Vérifie les dépendances entre modules
    new Documenter(modules)
      .writeDocumentation()
      .writeModuleMetadata()
      .writeModulesAsPlantUml() // Génère un diagramme PlantUML
      .writeIndividualModulesAsPlantUml()
      .writeModuleCanvases()
      .writeAggregatingDocument(); // Génère un diagramme par module
  }
}

