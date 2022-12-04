# Extending Functionality 

Here are a few ways we could extend the functionality of our application.

Say at one point, we want to implement some sort of content moderation. For example, if a user posts multiple listings selling the same car, the duplicate listings should be removed. Or if a user is known to be a scammer, the user's account should be banned and deleted. 

To accomplish this task, we should create of a new entity `UserAdmin`. We can easily modify our application to create this type of user. We have already have a simple factory design pattern for our all types of users. We could decide to continue using this pattern by simply adding another case to our conditional switch statement, or we could implement the abstract factory pattern. For the `UserAdmin` class, we could make it inherit the `User` class. So far, we have followed the 

# Design Patterns

## Simple Factory
We used the simple factory to create our different types of users, `IndividualUser` and `DealershipUser`. The simple factory is used to obscure the creation process for the two users and will be easy to change if we feel the need to add more types of users to our application in the future. 

## Dependency Inversion
We used the Depnednecy Inversion Design pattern multiple times in our applicatoin. For example,  we have used it whenever we wanted to access the databse  (csv files) from our use case. Take for instance at our displayListing use case. There, we implemented the `DispalyListingDsGateway` which is an interface that defines the functions that `displayListingRepo` implements. In our `DisplayListingInteractor`, we are dependent ont a the interface `DispalyListingDsGateway`. By using this design pattern throughout our app, we do not violate the dependency rule in clean archiecture. 

## Singelton
As their can only be one logged in user for the life time of the application, and all of our use cases require infromation of the user for authentication purposes, we needed to find a way to store the currently logged in user globally. As we only require the email and type of user for authentication purposes, we didn't think that it was good idea to just use an instancce of either an `IndividualUser` or a `DealershipUser` as they hold an excess of information we don't need. So we decided to use the singleton design pattern to represent the currently logged in user. Since we know that the singleton design pattern can be difficult to test with, we decided to add a reset method that should only be used for testing purposes. 


# Adressing feedback from Milestone 4

1. We have included tests for every use case, reaching test coverage of nearly 100%.
2. We have increased the detail of our previous pull request descriptions.
3. We implemented our final use case, `findNearestDealership` while stile following clean archiecture.
