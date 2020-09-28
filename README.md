# Testing Practice

<i>By Alicia Shen (alieevee)</i>

<h1> About </h1>

This project is about building a high quality test suite which maximises branch and conditional coverage, and another two test classes which improve the quality of the test suite; 
one class is based on a particular <b>du test-path</b>; the second class tests one particular <b>equivalence class</b>.

<h3>Preface</h3> 
<h4><i>Finding the weekday date for any given day after the Jan 1st, 1753</i></h4> 
The test suite and supporting test classes are for Dates#dayOfWeek(int, int, int) source code in the dates package. The implementation actually implements the so-called "doomsday rule" 
(a reasonable, albeit non-authoritative, description can be found on Wikipedia - <a href="https://en.wikipedia.org/wiki/Doomsday_rule" target="_blank"> click here </a>). 
The implementations supplied all follow the following outline:

<ol>

<li>Compute the century number for the year of the given date.
<li>Determine the century anchor for the year of the given date (which depends on the century number).
<li>Determine the doomsday for the year of the given date.
<li>Determine the doomsday date for the month of the given date (from the table).
<li>Determine how many days the doomsday date for the month is from the given date.
<li>Compute the day of the week for the given date by counting days from the doomsday date and doomsday.
</ol>

The method dayOfWeek(int, int, int) takes in three integers - year, month, day - and returns the weekday of the date. 
My job is to design tests that find faults in this code - through branch, conditional coverage, data-flow testing and equivalence class testing. 

<h1> Getting Started </h1>

Clone this project onto your preferred IDE, or alternatively, download this project and open it in terminal. 
Run the tests! 

<h1> Further Clarification </h1> 

Details about each class, justification of the logic used can be found in the javadoc comments. 

<h1> Contact </h1> 

I would love feedback anytime! Feel free to leave comments here! 






