# CollegeMatch

Anamika Basu, Ziyuan Li, Sai Akhil Pulikam, Charlie Yan

CollegeMatch is a Java application that helps students find the college of their dreams and helps college admin officers market their college to students!

**To run our application, run the following commands after cloning the repository**
1. cd project-collegematch
2. git checkout development 
3. bash runCollegeMatch.sh 

## Iteration 1
This iteration, we focused on the student side. Students can now register and login to the app, get college matches, and get information about certain colleges.

In the next iteration, we plan to work on the college admin officer side. Admin officers will be able to register and login to the app, edit college descriptions, and add new colleges to our "database."

Currently, there is an option to display saved colleges, but we have not added any functionality to add to saved colleges, so this list is always empty at this time. In the future, we will allow the user to edit their saved college list as a separate option on the menu. Additionally, simplifications were made. For example, our current college "database" consists of 4 saved colleges in the app itself. In the future, we will create a csv file that can be read and written to for our college database.

The 4 colleges are Dartmouth College, Havard College, Washington University, and Iowa State University.

## Iteration 2

This iteration, we got started on the admissions officer side and continued working on the student side. Admission officers can now login, register, and see a menu of options. When admission officers register they can also add their school to our "database" if their school is not already present. Students can now add and delete schools from their saved colleges list. 

In the next iteration, we plan to continue working on both the admission officer and the student side. On the admission officer side, we plan to allow admission officers to edit their school's information. We also plan to create a message board that students can visit and admission officers can add with exciting updates about their schools. On the student side, we plan to ask users whether they want to save colleges to their list when they get their college matches. Lastly, we plan to better handle errors from incorrect user inputs. 

## Iteration 3

This iteration, users login with usernames and passwords for more security. A sample username and password are provided below for a student and a college admissions officer for convenience, though you can still register as either a student or a college admissions officer. 

Student 
- username: mikib
- password: mikibasu

College Admissions Officer
- username: washu_rep
- password: washurules

Students can now save colleges after receiving their college matches. College admissions officers can view how many students saved their college to gauge interest and can now update their college information. Both students and college admissions officers can view a message board filled with updates, and college admission officers can also add to the message board. 
