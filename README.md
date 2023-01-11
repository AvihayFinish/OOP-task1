# waiters:
> Avihay Finish , 208907113

> Amit Rovshitz , 207701426

- [Our Project](#our-project)
    - [Introduction](#introduction)
    - [Getting Started](#getting-started)
    - [Observer](#observer)
    - [Classes](#classes)
    - [Tests](#Tests)


# Our Project:

> our project its a continue project of the project UndoableStringBuilder. 
> in this project we append the option to be a member of updating about the changes in the UndoableStringBuilder object.


# Introduction:

> in this project we use the Observer desgin pattern(We will elaborate on this later) to realizition the task.
> this project expands the capabilities of UndoableStringBuilder project, so that members can register to updating option about changes on
> the UndoableStringBuilder object. 

# Getting Started

> to get start this project, you just need to download the codes to your workspace and run them of any JDK.
> you need to build a main class, after that to build a GroupAdmin object and ConcreteMember object. register(we exlpain how and the other option later)
> the ConcreteMember to the GroupAdmin object and all changes you will do in the GroupAdmin, the ConcreteMember will know. 

# Observer

> the Observer desgin pattern, its a pattern that help us in problems of kind that somebody want to know the updating about something. so the pattern sujest
> that instead that the somebody always asked about changes, the something will let him know if there is a change.
> foe example - I want to follow after Donald Trump in twiter to know what he writes there. so instead of my account always asking Donald Trump if there a something
> knew he write,  my account will be notify if Donald Trump write something.
> to realizition this, we have to interfaces, Sender and Member, the somebody that will updating implements the Sender interface.
> in the class that implements Sender,
> ---
>  we build the all function we want for the class and additional three things:
> 1- some list that will hold all the members that registered.
> 2- a Notify function - in this function we will run of all the members in the list and turn the Update function off the members
> 3- some GetData function - that function return the data we want to update with the members.   
