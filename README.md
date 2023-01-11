# waiters:
> Avihay Finish , 208907113.

> Amit Rovshitz , 207701426.

- [Our Project](#our-project)
    - [Introduction](#introduction)
    - [Getting Started](#getting-started)
    - [Observer](#observer)
    - [Classes](#classes)
    - [Tests](#Tests)


# Our Project:

> our project its a continue project of the project UndoableStringBuilder. <br> 
> in this project we append the option to be a member of updating about the changes in the UndoableStringBuilder object. <br>


# Introduction:

> in this project we use the Observer desgin pattern(We will elaborate on this later) to realizition the task. <br>
> this project expands the capabilities of UndoableStringBuilder project, so that members can register to updating option about changes on
> the UndoableStringBuilder object. <br>

# Getting Started

> to get start this project, you just need to download the codes to your workspace and run them of any JDK. <br>
> you need to build a main class, after that to build a GroupAdmin object and ConcreteMember object. register(we exlpain how and the other option later). <br>
> the ConcreteMember to the GroupAdmin object and all changes you will do in the GroupAdmin, the ConcreteMember will know. <br>

# Observer

> the Observer desgin pattern, its a pattern that help us in problems of kind that somebody want to know the updating about something. so the pattern sujest
> that instead that the somebody always asked about changes, the something will let him know if there is a change. <br>
> for example - I want to follow after Donald Trump in twiter to know what he writes there. so instead of my account always asking Donald Trump if there a something
> knew he write,  my account will be notify if Donald Trump write something. <br>
> to realizition this, we have to interfaces, Sender and Member, the somebody that will updating implements the Sender interface. <br>
> in the class that implements **Sender:** <br> 
> we build the all function we want for the class and additional three things: <br> 
> 1- some list that will hold all the members that registered. <br>
> 2- a Notify function - in this function we will run of all the members in the list and turn the Update function off the members. <br> 
> 3- some GetData function - that function return the data we want to update with the members. <br>
> in the class that implements **Member:** <br>
> we just need to build a class with some variable that need to be same as the variable that the Sender will updating about him. additional we need to realiztion
> the update function. this function just get the chnages and put him in the variable off the class. <br>


# Classes:
> **GroupAdmin:** <br>
> **variables:** UndoableStringBuilder object and a list <br>
> **functions:** <br>
> 1. we have the constructors, one empty constructor that get nothing, and another that get a UndoableStringBuilder <br>
> 2. _register():_ this function get a Member obhect and add him to the list. <br>
> 3. _unregister():_ this function get a Member object and remove him from the list. <br>
> 4. _insert():_ this function get a int of offset and a String and insert the String in the offset index of the UndoableStringBuilde String. <br>
> 5. _append():_ this function get a String and insert him in the end of the UndoableStringBuilde String. <br>
> 6. _delete():_ this function get a int start and int end, the function remove the String between the index strat and index end of the UndoableStringBuilde String. <br>
> 7. _undo():_ this function get nothing. he just do undo.<br>
> 8. _notifyAll():_ this function get nothing. he run of all the members and turn the update function for each them.<br>

> **concreteMember:** <br>
> **variabels:** UndoableStringBuilder object <br>
> **functions:** <br>
> only a update function that updating the changes of the UndoableStringBuilder in the GroupAdmin.<br>


# Tests:
> we build three tests classes, two of them is a regular tests classes that uses the JUNIT, this tests only check if the functions in the GroupAdmin class and ConcreteMember class work well. <br>
> the third test is test about the memory of the program that use the JvmUtilities class. this test help us to follow up about the changes that happen in the memory after turn on each function in our classes. <br>
 
