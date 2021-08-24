Project structure

    feature:
        The project root is in the feature package; each feature package has project info which describes what each feature 
        file does. 
        Each feature is written in an English like language in order for stakeholder from all background to understand.
        Each feature also specifies the data source being used...navigate to the data source and update it if necessary.
    Tasks
        The actual implementation defining steps taken to perform a certain action
    Question
        Question asked to make sure action preformed resulted in expected results
    UI
        Holds all element of the ui the program interacts with for maintainability and reuse  
     
Running the Project

    Run all Tests: mvn clean verify
    
