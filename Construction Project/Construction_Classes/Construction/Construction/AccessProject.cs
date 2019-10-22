using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Construction
{
    class AccessProject
    {
        private DataAccess da;

        public AccessProject()
        {
            da = new DataAccess();
        }

        public void AddNewProject(string date, string name, string contactNo, string plotNo, string status)
        {
            Project project = new Project();
            project.contactNo = contactNo;
            project.date = date;
            project.name = name;
            project.plotNo = plotNo;
            project.status = status;


            da.insertProject(project);
            // insert to database;

            

        }
        public List<Project> GetProjects()
        {
            //get from database
            List<Project> projects = new List<Project>();
            da.getAllData("project");

            return projects;
        }

    }
}
