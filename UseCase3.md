# USE CASE 2: SERVER RECEIVES FEEDBACK AND DATA ACTIVITIES #
**Primary factor:**
> developers of the application
**Scope:**
> server side from receiving feedback data from users to release fix/patch
**Level:**
> server goal
**Stakeholders and Interests:**
> Server wants to know the accuracy of the estimated time the app provides. It also interests in building the database of all on-time alarm for helping all users who uses the app
**Precondition:**
> available feedback from users and user profile activities which is guarantee anonymous.
**Minimal Guarantees:**
> server saves all the feedback and profile activities for later usage.
**Success Guarantees:**
> server builds the better model to improve the accuracy of alarm time
**Trigger:**
> Use submits the feedback
**Main success scenario:**

  * 1. User submits the feedback and allows activity profile to be sent to server.

  * 2. Server receives all feedbacks and activity profiles from users

  * 3. Server saves all data, also backup.

  * 4. Developers compare the real data and calculated data to evaluate the accuracy of alarm time

  * 5. Developers improves the algorithms and sends the fix to user app

  * 6. User uses the app with the fix. Back to step 1.

**Extension:**
  * 1a. User doesn't submit the feedback and not allow profile to be sent
    1. 1. Server does nothing and quit use case

  * 2a. Server can't receive feedback and activity profiles
> > 2a1. Developers check the network setting and server connection.
> > 2a2. If successful, go to step 3. Otherwise, back out of use case.

  * 3a. Server can't save all data.
> > 3a1. If the storage is full, developers need to provide the new one or the server backs out of use case
> > 3a2. If the storage is broken, replace the new one with the backup version

  * 4a. If the developers can't find the significant difference between real and calculated alarm time, backs out the use case :D

  * 5a. Developers can't provide the better algorithm
> > 5a1. Don't send out any fix

  * 6a. User don't use the app anymore.
> > 6a1. Developers do nothing.