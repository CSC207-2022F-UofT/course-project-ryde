# About the App

Welcome to Ryde! Ryde is a Java Desktop application that allows you to find cars to buy near your area. 

You can register and login wheter your just someone who's looking for a new car, or a dealership that wants to show your great deals. Note that individual users can only create five listings to stop spam.

Once you login you can create a listing by specifing details about the car you want to sell. You can view listings and filter them by properties such as color, brand, year, used etc. You can also delete a listing whenever you have sold you car. 

For your convience, we have also made it easy to find the closest dealership to your location. Just click on the find dealership button, enter your zipcode, and the closest dealership to you will be given.

# Extending Functionality 

Here are a few ways we could extend the functionality of our application.

Say at one point, we want to implement some sort of content moderation. For example, if a user posts fake information about a listing, that listings should be removed and the user's account should be banned. 

To accomplish this task, we should create of a new entity `UserAdmin`. We can easily modify our application to create this type of user. We have already have a simple factory design pattern for our all types of users. We could decide to continue using this pattern by simply adding another case to our conditional switch statement, or we could implement the abstract factory pattern. For the `UserAdmin` class, we could make it inherit the `User` class. We have made the parent User class minimal, so `IndividualUser`, `DealershipUser` and any other type of user we add in the future doesn't violate the Liskov Substituion Principal. We could then reuse the same code we already have to register and log in users.

# Program Structure

In src/main/java, we have the code of the applicatoin. We structured our program into packages, each belonging to a layer in clean archiecture. 
In src/main/java/test we have our test files which mirror the structure for our src/main.

# Design Patterns 

## Simple Factory
We used the simple factory to create our different types of users, `IndividualUser` and `DealershipUser`. The simple factory is used to obscure the creation process for the two users and will be easy to change if we feel the need to add more types of users to our application in the future. 

## Dependency Inversion 
We used the Depnednecy Inversion Design pattern multiple times in our applicatoin. For example,  we have used it whenever we wanted to access the databse  (csv files) from our use case. Take for instance at our displayListing use case. There, we implemented the `DispalyListingDsGateway` which is an interface that defines the functions that `displayListingRepo` implements. In our `DisplayListingInteractor`, we are dependent ont a the interface `DispalyListingDsGateway`. By using this design pattern throughout our app, we do not violate the dependency rule in clean archiecture. 

## Dependency Injection
Throuhgout our project, we used dependency injection. For example, our interactor uses it's respective response model. We don't create the response nodel in the interactor lass, rather we pass it down from the controller. This makes our code more testable and improves code readability.

## Singelton
As their can only be one logged in user for the life time of the application, and all of our use cases require infromation of the user for authentication purposes, we needed to find a way to store the currently logged in user globally. As we only require the email and type of user for authentication purposes, we didn't think that it was good idea to just use an instancce of either an `IndividualUser` or a `DealershipUser` as they hold an excess of information we don't need. So we decided to use the singleton design pattern to represent the currently logged in user. Since we know that the singleton design pattern can be difficult to test with, we decided to add a reset method that should only be used for testing purposes. 
