# org-popular-repos
Most popular repositories of a given organization on Github based on the number of forks.

# Steps to set up the environment and run the application
1. Open the project in any IDE.
2. Right click on `lib/json-simple-1.1.jar` & select `Add as library` option.
3. Right click on `src` & select option `Mark directory as` -> `Source root` 
4. Set the configuration for project compiler output (`File -> Project Structure -> Project Setting -> Project -> Project compiler output`)
5. Configure project SDK (`File -> Project Structure -> Project Setting -> Project -> Project SDK`)
6. Add application configuration (Choose `client.Client` as `Main class`)
7. Build the application & run it

# Input format
org-name repo-count committees-count
ex: google 2 3

# Output format
The application prints list of m repos with n committees (m = repo-count, n = committees-count).

ex:for input = google 2 3
```
styleguide: 8680 
List of committees:
  eglaysher: 25     
  IsaacG: 25     
  tonyruscoe: 18
----------------------------- 
guava: 8227 
List of committees:      
  cpovirk: 1387     
  kluever: 557     
  cgdecker: 493
```
