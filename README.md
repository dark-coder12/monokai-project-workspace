# monokai-project-workspace
A Desktop App built in entirely Java, with the frontend using Swing. This Application mainly aims to provide all project workspace oriented features in one place.

Abstract

The proposed system shall be a newly developed desktop-based product that fits appropriately into the domain of project workspaces. The name put forth for the system is Monokai. Monokai will be a multi-purpose workspace environment catering for an audience of software developers. Productivity, enhancing code quality, setting a clutter-free space, organizing tasks, code editing, setting reminders or even analyzing one’s progress analytics are the currently offered features that will make Monokai stand out as a desktop application. Additionally, Agile Methodologies shall be supported by Kanban boards. As far as the user scope is concerned, it will be a single-user application, as it is going to run on desktops. Monokai is a perfect opportunity to amalgamate integral tools that are often scattered on different websites but never found all in one and that too on a desktop environment. 

Demo Images

![1](https://user-images.githubusercontent.com/82564549/214557088-82c74908-d129-41f9-9f77-7e70d311de1b.png)
![2](https://user-images.githubusercontent.com/82564549/214557091-b3b79090-34f6-4887-aa34-bbe198b31e87.png)
![3](https://user-images.githubusercontent.com/82564549/214557092-651f7595-c23c-4108-a687-d491efe1ef36.png)
![4](https://user-images.githubusercontent.com/82564549/214557098-96517747-2343-4fa4-aa1f-12de575c1168.png)
![5](https://user-images.githubusercontent.com/82564549/214557100-e9e9bbb4-b55f-445b-9ad3-aafb1a79a0fb.png)
![7](https://user-images.githubusercontent.com/82564549/214557104-f53302dc-e50a-4727-8e8c-5982a906d3f0.png)
![8](https://user-images.githubusercontent.com/82564549/214557107-33c6adb6-8614-4c36-a747-22b9e2631935.png)
![10](https://user-images.githubusercontent.com/82564549/214557070-576b016a-fcaf-410b-8e16-bb9e4149fa6a.png)
![11](https://user-images.githubusercontent.com/82564549/214557154-b19eece4-abb7-4896-bbeb-c291157a4c80.png)


Motivation

As software engineer students we are aware that project management for any system can be a big hassle. Most people are unable to keep a track of the deadlines, requirements, and tasks that are completed or in progress. These small hurdles can end up creating big problems for the developers hence we thought of making Monokai, an efficient project management workspace. A compact place where you can not only edit the code in style but also keep track of your progress. Moreover, it has a potential to be explored and in the following increments can be integrated with more features to facilitate the user. We plan to add a stress management feature like calm and a health tracking system once the application is received well in the market for the current features.


Tools

The system shall be a completely Java-based application in terms of its front and back end. Java Swing is the perfect choice for our application, since Monokao will be hosting numerous features that require high UI support. This library hosts quite a few impressive UI components that will be pivotal in our development. As far as the backend is concerned, it will be in Java Swing and MySQL. My SQL is known to easily integrate with Java, thus it will be opted for as our primary database.


Features

1. Code Editor

Code editors are essential when it comes to a Project Workspace. Such editors are used by developers to write and edit code, and in turn, contribute to the development of software. Code lookups and comfortable code editing spaces result in efficient coding and shortened development time.

These may be of multiple benefits to the user, mainly;

- Quick Code Viewing
- Adding Codes into Projects
- Writing High-Quality Code Snippets
- Maintaining Code Indentation

Propped with essential themes every code editor must-have, this editor will feature diverse backgrounds, comfortable fonts and minimalism. The themes shall be inspired from the highly aesthetic Monokai to the simple Atom One.

User Stories
- The system shall be able to display a minimalist code editor window.
- The system shall be able to support different backgrounds and fonts.
- The system shall be able to allow code viewing.
- The system shall be able to download code snippets.
- The system shall be able to allow code writing and editing.


2.Kanban Board

Kanban Boards are an exquisite way to visualize one’s work in terms of various columns that help with division and maximize efficiency. Project tasks are represented on Kanban boards, thus dealing with projects comes easier and optimization is achieved. This has been regarded as one of the top tools in Project Workspaces for a long time now.

Since this is a desktop application, individuals can use “personal Kanban” for each project to manage solo projects from college applications to personal projects.

- A standardized visual method
- Column division with easy swapping
- Representation of stages of work

User Stories
- The system shall be able to add sprint logs to the board.
- The system shall be able to remove sprint logs from the board.
- The system shall be able to update any of the sprint logs on the board.
- The system shall be able to support a Kanban board for each Project separately.
- The system shall be able to divide the board into three columns that denote Not Yet Done, In Progress and Complete.
- The system shall support either drag and drop or a seamless swapping feature in between the columns as per the user’s progress.
- The system shall have certain visual differences amongst each of the columns for ease of use and readability.

3.To-Do List

A To-Do List is a list of documents containing tasks that are to be done by the user. It facilitates the user to maintain their checklist to keep a track of tasks the user has to perform. The items are known as to-do items.
This has been regarded as one of the top tools in terms of enhanced productivity.

- A simple visual method
- Efficient checklist maintenance 
- Representation of personal progress

User Stories
- The system shall be able to create a to-do document
- The system shall be able to view a to-do document
- The system shall be able to create a to-do item
- The system shall be able to delete a to-do document
- The system shall be able to delete all to-do documents
- The system shall be able to delete a to-do item
- The system shall be able to mark a to-do item as done
- The system shall be able to mark all to-do items as done

 4.Performance Analytics

Performance analytics display the overall current progress of the user. It is an interface, following the human-computer interaction standard. It enables the user to track the performance of the system through visual and statistical representations of system details. This has been regarded as one of the top tools in terms of system performance analysis.

- A standardized visual method
- Efficient performance measurement
- Representation of user progress

User Stories
- The system shall display over all number of code lines 
- The system shall display overall performance statistics
- The system shall display the languages user has worked on
- The system shall display total number of to-do documents
- The system shall display total tasks in the kanban board


5.Gantt Chart

A Gantt chart is a project management tool assisting in the planning and scheduling of projects of all sizes, although they are particularly useful for simplifying complex projects. This is useful to keep tasks on track when there is a large team and multiple stakeholders when the scope changes.
As it's in a bar chart format it is possible to check on progress with a glance. You can easily see:

- A visual display of the whole project
- Timelines and deadlines of all tasks
- Relationships and dependencies between the various activities
- Project phases

User Stories
- The system shall allow the user to add the tasks within the gantt chart. This is done using an ID, name, start and end date, and linking of dependencies.
- The system shall allow the user to edit an existing task of the chart.
- The system shall allow the user to remove unnecessary tasks from the chart.
- The system shall allow the user to view a timeline of the added tasks in a linear fashion.


6.Reminders

We got a long list of tasks in a day to do, so Reminders is an efficient functionality with which users are reminded to perform tasks in time. Reminders for several tasks are set by the user on a specific day and date and then users are reminded to perform those tasks at the right time. This functionality increases the usability of the application by not letting users keep in mind a lot of reminders. 

User Stories
- The system shall allow users to set a reminder for a task
- The system shall allow users to set reminders anytime on the current day
- The system shall allow users to  set reminders anytime for an upcoming day
- The system shall allow users to snooze the reminder
- The system shall allow users to increase the time limit for the reminder
- The system shall allow users to set repeatable reminders.
- The system shall allow users to repeat reminders on a weekly, yearly and monthly basis	
- The system shall alert the user once the user missed a reminder
- The system shall allow users to delete a set reminder
- The system shall remind users of their set reminder

