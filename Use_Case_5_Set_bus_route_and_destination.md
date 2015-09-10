**Primary factor:**
> person who is taking bus (User)
**Scope:**
> Android app "Bus Stop Alarm", user starts to select the bus route till the destination is set.
**Level:**
> user level
**Stakeholder and Interests:**
> User -- wants to set the alarm to wake him/her up on time at the pre-set location automatically.

> App -- wants user to input the bus route and the destination location.
**Precondition:**
> User has the program opened, and available internet connection.
**Minimal Guarantee:**
> No minimum guarantee. Remains on the same page until the input bus and destination are valid.
**Success Guarantee:**
> The bus route and destination are selected properly and the application successfully finds user's location.
**Main Success Scenario:**
  * 1. User inputs the bus route.
  * 2. App finds user's location.
  * 3. User select the destination from Favorites Menu or from Major Locations
  * 4. Application switches to next page to choose alarm settings.

**Extensions:**

  * 1a. User doesn't input the bus route
    * 1a1. User backs out or input the bus route

  * 2a. User doesn't allow system to identify his/her location.
    * 2a1. User backs out the use case or accept to identify his/her location

  * 2b. System can't locate user location
    * 2b1. Check if internet connection and GPS device are working properly
    * 2b2. Try to locate user's position again
    * 2b3. If fail,  system notifies failure to user and backs out of use case
  * 3a. If the Favorites menu doesn't have any location
    * 3a1. User have to select location in Major location menu or backs out
  * 3b. If the Major location menu doesn't have any location
    * 3b1. Back to step 2.
  * 3c. If user doesn't select location from Favorite/Major location menus:
    * 3c1. User either backs out or selects location to continue
  * 4a. Application doesn't switch to next page to choose alarm settings
    * 4a1. Application checks destination location and bus route, GPS settings
    * 4a2. If everything is correct, try go to next page. If fail again, backs to main page
    * 4a3. If one of requirement has an issue, start the use case again from step 1.