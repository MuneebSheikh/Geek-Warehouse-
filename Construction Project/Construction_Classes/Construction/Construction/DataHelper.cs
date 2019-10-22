using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Construction
{
    class DataHelper
    {
        SqlCommand cmd = new SqlCommand();
        //DataTable dt;
        SqlDataAdapter adp;
        DataSet ds;
        //SqlDataReader dr;
        SqlConnection con;

        ///array///
        string[] projectCols = { "@p_name", "@p_plotno", "@p_contactno", "@p_date", "@p_status", "@p_totalamount" };
        public DataHelper()
        {
            string connetionString;
           
            connetionString = @"Data Source=MUNEEB-PC;Initial Catalog=contructionSystemDB;Integrated Security=True";
            con = new SqlConnection(connetionString);
            con.Open();
            con.Close();
        }

        //public DataSet getAllData(String tableName, params object[] colNames)
        //{

        //    try
        //    {
        //        ds = new DataSet();
        //        if (con.State == ConnectionState.Closed)
        //            con.Open();
        //        Console.WriteLine("Number of Colomns: " + colNames.Length);
        //        Console.WriteLine("Selecting Data...");
        //        string cols = "", query = "";
        //        Console.WriteLine(colNames.Length);

        //        //... if No of columns is 0 return all columns

        //        //using for each loop to display colNames

        //        for (int i = 0; i < colNames.Length;i++)
        //        {
        //            Console.WriteLine("col Name: " + colNames[i]);
        //            // here concate all the colnames in one string variable for query
        //            cols = string.Concat(colNames[i] + ",");
        //        }
        //        // remove the last ,(comma) from the string
        //        cols = cols.Substring(0, cols.Length - 1);

        //        //            query = "SELECT "+ colNames[0] +" FROM "+ tableName + " where "+ colNames[0] +" = (select max("+ colNames[0] +") from "+tableName+")";
        //        if ("\0".Equals(colNames[0]))
        //        {
        //            query = "SELECT * FROM " + tableName;
        //            using (adp = new SqlDataAdapter("@"+query, con))
        //                adp.Fill(ds, tableName);
        //            // SELECT * FROM TABLE

        //        }
        //        else
        //        {
        //            query = "SELECT " + cols + " FROM " + tableName;
        //            using (adp = new SqlDataAdapter("@"+query, con))
        //                adp.Fill(ds, tableName);
        //            // SELECT + 'cols' + FROM TABLE

        //        }

        //        Console.WriteLine(query);
                

        //            con.Close();
        //            return ds;
        //        // run querries here
        //        // return all the required data in resultSet
        //    }
        //    catch (Exception e)
        //    {
        //        Console.WriteLine("DbHelper->Exception: " + e);
        //    }
        //    return null;
        //}


        ///////////Project Methods/////////////

        public DataSet fetch_AllData(string tablename)
        {
            try
            {
                if (false)
                {
                    Console.WriteLine("enter name to search");
                    return null;
                }
                else
                {
                    ds = new DataSet();
                    
                    if (con.State == ConnectionState.Closed)
                        con.Open();
                    using (adp = new SqlDataAdapter(@"select * from "+tablename, con))
                        adp.Fill(ds, tablename);

                }
                return ds;
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
                return null;

            }
            finally
            {
                if (con.State == ConnectionState.Open)
                {
                    con.Close();
                }
            }
        }

        public void insert_project(params object[] v)
        {
            try
            {
                String query = "INSERT INTO project(p_name,p_plotno,p_contactno,p_date,p_status,p_totalamount)VALUES(@p_name,@p_plotno,@p_contactno,@p_date,@p_status,@p_totalamount)";
                using (cmd = new SqlCommand(query, con))
                {
                    
                    for (int i = 0; i < v.Length; i++)
                    {
                        cmd.Parameters.AddWithValue(projectCols[i], v[i]);
                    }

                    con.Open();
                    int result = cmd.ExecuteNonQuery();
                    if (result < 0)
                        Console.WriteLine("Record Not Insert");
                    else
                        Console.WriteLine("Record Inserted!");
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
            }
            finally
            {
                if (con.State == ConnectionState.Open)
                {
                    con.Close();
                }
            }
        }

        public void update_project(string value,params object[] v)
        {
            try
            {
                if (value == null)
                {
                   Console.WriteLine("enter name please");
                }
                else
                {
                    String query = "Update project set p_name = @p_name, p_plotno = @p_plotno, p_contactno = @p_contactno, p_date = @p_date, p_status = @p_status, p_totalamount = @p_totalamount where p_name = @p_check";
                    using (cmd = new SqlCommand(query, con))
                    {

                        for (int i = 0; i < v.Length; i++)
                        {
                            cmd.Parameters.AddWithValue(projectCols[i], v[i]);
                        }
                        cmd.Parameters.AddWithValue("@p_check", value);


                        con.Open();
                        int result = cmd.ExecuteNonQuery();
                        if (result < 0)
                            Console.WriteLine("Record Not updated");
                        else
                            Console.WriteLine("Record updated!");
                    }
                }
            }
            catch (Exception ex)
            {
               Console.WriteLine(ex.Message);
            }
            finally
            {
                if (con.State == ConnectionState.Open)
                {
                    con.Close();
                }
            }
        }

        public void delete_project(string name)
        {
            try
            {
                if (name == null)
                {
                    Console.WriteLine("enter name please");
                }
                else
                {
                    String query = "delete from project where p_name = @p_name";
                    using (cmd = new SqlCommand(query, con))
                    {

                        //cmd.Parameters.AddWithValue("@id", ID);
                        cmd.Parameters.Add("@p_name", name);

                        con.Open();
                        int result = cmd.ExecuteNonQuery();
                        if (result < 0)
                            Console.WriteLine("Record Not delete");
                        else
                            Console.WriteLine("Record delete!");
                    }
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
            finally
            {
                if (con.State == ConnectionState.Open)
                {
                    con.Close();
                }
            }
        }

        public DataSet fetch_SingleData(string tablename, string col,string val)
        {
            try
            {
                if (false)
                {
                    Console.WriteLine("enter name to search");
                    return null;
                }
                else
                {
                    ds = new DataSet();

                    if (con.State == ConnectionState.Closed)
                        con.Open();
                    using (adp = new SqlDataAdapter(@"select * from "+tablename+" where "+col+" = "+val, con))
                        adp.Fill(ds, tablename);

                }
                return ds;
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
                return null;

            }
            finally
            {
                if (con.State == ConnectionState.Open)
                {
                    con.Close();
                }
            }
        }

    }
}
