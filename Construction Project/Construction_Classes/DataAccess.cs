using Construction;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace constructionproject
{
    public class DataAccess
    {
         DataHelper DH; 
        public DataAccess()
        {
            DH = new DataHelper();
            
        }



        //public List<Project> GetProject(){
        //    try
        //    {
        //        DataSet dss = DH.getAllData("project","p_name","p_plotno","p_contactno","p_date","p_status","p_totalamount");
        //        LinkedList<Project> project = new LinkedList<Project>();
        //        foreach (DataSet ds in dss.Tables)
        //        {
        //            Project l = new Project(ds.Tables[0].Rows[0]["p_name"].ToString(), ds.Tables[0].Rows[0]["p_plotno"].ToString(),
        //                    ds.Tables[0].Rows[0]["p_contactno"].ToString(), ds.Tables[0].Rows[0]["p_date"].ToString(), ds.Tables[0].Rows[0]["p_status"].ToString(),
        //                    ds.Tables[0].Rows[0]["p_totalamount"].ToString());
        //            project.AddLast(l);
        //        }
        //        return project;

        //    }catch (Exception e) {
            
        //        Console.WriteLine("Exception: " + e);
        //    }
        //        return null;
        //}

        public DataSet getAllData(string tablename)
        {
            DataSet ds = DH.fetch_AllData(tablename);
            return ds;
        }

        public void insertProject(params object[] v)
        {

            DH.insert_project(v);

        }

        public void deleteProject(string name)
        {
            DH.delete_project(name);
        }

        public void updateProject(string val,params object[] v)
        {
            DH.update_project(val,v);
        }

        public DataSet get_SingleRecord(string tablename,string val)
        {
            DataSet ds;
            //table aiga usko dekh kar unique col specify karna hai phir function me pass values aur dataset me return
            if (tablename == "project")
            {
                ds = DH.fetch_SingleData(tablename,"p_plotno",val);
                return ds;
            }

            return null;
        }
    }
      
}
