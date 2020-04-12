# FINAL1

######IMPORTANT 

Regarding Video: Due to editing issues, we arent really pro with editing, the video got cut into half but it still covers the major part of it. Kindly request you to not get disgusted by the quality of video since it was a editing fault which wasnt really our arena. Kindly excuse.


WE HAVE EDITED THE VIDEO PROPERLY AS : https://youtu.be/dfWjwT5DXmg

Its the same video but in portrait mode so that the full app is seen. Kindly check thiws out.


READ BEFORE PROCEEDING #########

THIS REPOSITORY CONTAINS MULTIPLE PROJECTS

CONTAINS 3 APPS

APP1: QUARAN WATCH

APP2: LocTag
GITHUB REPO LINK FOR SECOND APP: https://github.com/CrzyGamer01/LocTag

APP3: https://github.com/DisasterCoder576/FOOD

SINCE WE HAVE THREE APPS AND WE ARE NOT SURE HOW TO UPLOAD THREE APPS IN THE SAME REPOSITORY PLEASE KINDLY ACKNOWLEDGE THE SOURCE CODE 
OF THE THIRD APP IN THE LINK FORMAT. WE HAVE PROVIDED THE LINK OF THE THE THIRD APP AS A GITHUB REPOSITORY. KINDLY CONSIDER.

THE FOLDER OF THE SECOND APP LOCTAG IS WITHIN THE FOLDER OF QUARAN WATCH (BECAUSE THATS HOW SUBMODULES WORK)

********IT IS NAMED : LocTag @ 23024cc************ (THIS FOLDER TO BE REMOVED AND PLACED SEPERATELY WHILE RUNNING WITH ANDROID STUDIO.
WE HAD TO UPLOAD THIS FOLDER AS A SUBMODULE IN GITHUB BECAUSE THERE WAS ONLY ONE LINK BOX AND WE COULD PAST ONLY ONE REPOSITORY

KINDLY SEPERATE IT OUT AS A SEPRATE APP WHILE RUNNING THE APP IN ANDROID STUDIO


QUARAN WATCH: TITLE

DATA FLOW: Counter data resides wihtin the app only
          The food service app stores data in an online server. So that it can be sent across. 
          the online server can be accessed by: To open database
Go to  http://18.191.58.234:80/apps
username: user
p: WE will be able to grant acxcess privately to eyantra alone and not to anyone else if asked for. Since this repository maybe visible to everyone on the internet. 


REQUIREMENTS: ANDROID NOUGAUT OR ABOVE
APK 23 or above

PROCESS FLOW:


APP1: QuaranWatch

User sets HOME ADDRESS. HOME is saved locally. cant be modified by user anymore. Counter is automatic. It starts when the user considerably gets out of the range of his home. It gets back to pgetting paused when user is back home. 


App2:
LocTag
It can show your current location that the person is delievering food to. The delivery personnel can mark the current location as being delievered. Technically it is supposed to be saved in the database above so they can keep a check on delievered locations. Its being implemented. The user can view of list of delievered locations.

App3:
QuaranFood

During the process of delievery the personnel may have missed certain homes. Those people in those homes cannot come out. They send a request to the manager of the services. This location data goes to the ParseServer as a request and comes back to the manager personnel. he can look at the requests, cross verify with the data base of homes to which he has delievered and give them the required food. The confirmation goes. He can see the location of the home. The app then redirects to Google Maps to show the route.



IDEA:

In a large country such as India apart from focusing on medical care, it is imperative to restrict people at their own homes as a preventive measure. With this in mind, let us not forget that people need to go out for essentials also. At times, it happens that police mistakenly attack legitimate people who go out for bare essentials. There is no way for them to prove that they are actually out for essentials and are not uselessly loitering around. Police also can not verify that information. With a tracking system, the govt. and police can effectively limit the time people spend outside. We need to restrict the time for which a person can step out of their homes. A family has a weekly quota for which they can come out side for essentials. An android app can track this and save transit information. If confronted by the police the users can prove that they are well within the stipulated limit and the police need not take action. Police that patrol the roads can check the apps of people and find out the time for which they are out. If they have crossed the limits action can be taken. With this system we can make sure nobody goes out unnecessarily. Users will have to keep their phones charged and have the app installed. Police will have to enforce the app to wanderers and check if they have had the app installed subsequently. Before going out, they'll have to mark their target location and if the police catch them they can show that information obtained via tracking and necessary action be taken. Police servers will receive information about regular time limit defaulters and have them busted. Exceptions for doctors and other important people will exist of course. With his we can make people stay at home as a fool proof method. 
We are also planning an additional app that helps officers who check houses go around localities and deliver food and essentials in CASE OF A COMPLETE LOCK DOWN IF THE GOVT seals the whole area off people. It will serve as a register that helps such officers who rely on paper documents to store data of status of food delivered or not. They can keep a check and not miss out on any house of essentials or else they will suffer. We aim to digitalise the verification of food  and essentials delivery of Quarantine process. Officers will be able to store the locations to which food has been delivered and which areas have not received essentials yet.

We have another app, which in the above case, officers may miss out on a home to deliver food or essentials, the users can request the essentials to the concerned officers with a login. They will receive a request for food on the app based on user request. The officer will be able to see the location verify with the database of food has been delivered or not and deliver it. He will see google map Route making it much easier for him to navigate only on the press of a button.

Based on number people planning to visit an area, based on how busy it's is we may be able to divert people or make them postpone their transit to a less crowded time so that we can effectively manage crowds. This will help the police in managing crowds and restrict user movement. People will be advised based on live data not to go to a particular place as it maybe overcrowded.


