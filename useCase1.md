#SET A BUS STOP ALARM IN MOBILE APP

# USE CASE 1: SET A BUS STOP ALARM IN MOBILE APP #

**Primary Actor**: App user who is taking a bus.

**Scope**: Android App "Bus Stop Alarm", user starts using this App on a bus until he/she arrives at their desired bus stop.

**Level**: User level

**Stakeholder and Interests:**
  * User -- wants to set an alarm to get off the bus on time at his/her desired location.
  * App -- satisfies user with its functions.

**Precondition:** User has the App open on his/her Android phone
> // I deleted internet connection available because it would contradict step2 extension.

**Minimal Guarantee:** Alarm is set based on predefined time.

**Success Guarantee:** Alarm is set correctly and it alerts user to get off bus on time. User activities are saved in the system for future use.

**Main Success Scenario:**
  * 1. User allows App to identify his/her location.
  * 2. App finds user's current location.
  * 3. App provides all the bus routes that are currently available to user.
  * 4. User chooses a bus route and a destination bus stop.
  * 5. App calculates time and sets an alarm at every time frame. (USE CASE 2: Adjusts Alarm)
  * 6. App alerts user when time is up. (when user arrives at destination)
  * 7. User provides feedback which is saved in database for future use.

**Extensions:**
  * 1a. User doesn't allow system to identify his/her location.
    * 1a1. User either backs out of use case or inputs the location he/she wants to start.
  * 2a. App is unable to connect to Internet.
    * 2a1. App checks the network setting and tries to reconnect.
    * 2a2. If it fails, it shows an Internet disconnection message to user, then quits the program.
  * 3a. There is no bus route available in the list.
    * 3a1. App informs user that there is no bus route to choose.
    * 3a2. User either backs out of this use case or goes to step 2.
  * 5a. User doesnt' agree with the alarm time.
    * 5a1. User sets the alarm manually.
  * 6a. App does not alert user on time, or it does not ring at all.
    * 6a1. User sends feedback to server, and quits the program.
  * 7a. User doesn't want to provide feedback
    * 7a1. User backs out of this use case.



# Details #

Add your content here.  Format your content with:
  * Text in **bold** or _italic_
  * Headings, paragraphs, and lists
  * Automatic links to other wiki pages