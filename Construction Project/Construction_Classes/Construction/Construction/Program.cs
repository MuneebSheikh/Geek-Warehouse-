using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Construction
{
    class Program
    {
        static void Main(string[] args)
        {
            Project project = new Project();

            AccessProject p = new AccessProject();
            p.AddNewProject("12-22-19", "muneeb", "023445", "R-123", "in Progress");

            
            //project.plotNo = "12.2";
            //string temp = project.plotNo;
            //Project.Payment p = new Project.Payment();
            //p.amount = "12";
            //p.date = "01/02/19";
            //p.description = "hellos";
            //p.serialNo = "1";

            //project.payments.Add(p);

            //p.amount = "9090";
            //p.date = "02/03/19";
            //p.description = "word";
            //p.serialNo = "2";
            //project.payments.Add(p);

            //for (int i = 0; i< project.payments.Count; i++)
            //{
            //    Console.WriteLine("Date: " + project.payments[i].date + " S.No: " + project.payments[i].serialNo +
            //        " Amount: " + project.payments[i].amount + "Desc: " + project.payments[i].description);

            //}

            //foreach (Project.Payment py in project.payments)
            //{
            //    Console.WriteLine("Date: " + py.date + " S.No: " + py.serialNo + 
            //        " Amount: " + py.amount + "Desc: " + py.description);
               
            //}
            //Console.WriteLine("Generating bill...");
            //Project.Bill bill = new Project.Bill();
            //bill.amount = "150";
            //bill.billNo = "1";
            //bill.date = "08/10/19";
            //bill.particular = "Tiles";
            //bill.type = "NAAM";
            //Console.WriteLine("Generating Worker...");
            //Project.Worker worker = new Project.Worker();
            //worker.CNIC = "4201-123412-2";
            //worker.contactNo = "0323213";
            //worker.email = "worker@gmai.com";
            //worker.personName = "My name";
            //worker.bills.Add(bill);
            //Console.WriteLine("Printing");


            //project.workers.Add(worker);

            //foreach (Project.Worker w in project.workers)
            //{
            //    Console.WriteLine(w.email);
            //    foreach(Project.Bill b in w.bills)
            //    {
            //        Console.WriteLine(b.billNo);
            //    }
            //}

            //Console.WriteLine(project.plotNo);
            Console.ReadLine();

        }
    }
}
