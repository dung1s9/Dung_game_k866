using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BTVN_1
{
    internal class Program
    {
        static void Main(string[] args)
        {
            {
                //int a = int.Parse(Console.ReadLine());
                //string so1 = "Sports";
                //string so2 = "Politics";
                //string so3 = "BUsiness";
                //string so4 = "Teachnology";
                //string so5 = "Art";
                //switch (a)
                //{
                //    case 1:
                //        Console.WriteLine(so1);
                //        break;
                //    case 2:
                //        Console.WriteLine(so2);
                //        break;
                //    case 3:
                //        Console.WriteLine(so3);
                //        break;
                //    case 4:

                //        Console.WriteLine(so4);
                //        break;
                //    case 5:
                //        Console.WriteLine(so5);
                //        break;
                //}
                ////bai 2

                //{
                //    Console.WriteLine("player selects the difficulty level:");
                //    Console.WriteLine("1 - Easy");
                //    Console.WriteLine("2 - Medium");
                //    Console.WriteLine("3 - Hard");
                //    int a = int.Parse(Console.ReadLine());


                //    switch (a)
                //    {

                //        case 1:
                //            Console.WriteLine("Easy");
                //            break;
                //        case 2:
                //            Console.WriteLine("Medium");
                //            break;
                //        case 3:
                //            Console.WriteLine("Hard");
                //            break;
                //        default:
                //            Console.WriteLine(" Invalid option ");
                //            break;
                //    }
                //    // bai 3
                //    {
                //        Console.WriteLine("read any day number in integer and display day name in the word");
                //        int d = int.Parse(Console.ReadLine());
                //        switch (d)
                //        {
                //            case 2:
                //                Console.WriteLine("monday");
                //                break;
                //            case 3:
                //                Console.WriteLine("tuesday ");
                //                break;
                //            case 4:
                //                Console.WriteLine("wednesday ");
                //                break;
                //            case 5:
                //                Console.WriteLine("thursday ");
                //                break;
                //            case 6:
                //                Console.WriteLine("friday ");
                //                break;
                //            case 7:
                //                Console.WriteLine("saturday ");
                //                break;
                //            case 8:
                //                Console.WriteLine("sunday");
                //                break;

                //            default:
                //                Console.WriteLine("illegal");
                //                break;

                // bai 4.
                //int m;
                //Console.WriteLine("Nhập số và hiển thị số bằng chữ tương ứng. Nhập một số bất kì (0-9): ");
                //m= Convert.ToInt32(Console.ReadLine());
                //switch (m)
                //{
                //    case 0:
                //        Console.WriteLine("Số không");
                //        break;
                //    case 1:
                //        Console.WriteLine("Số một");
                //        break;
                //    case 2:
                //        Console.WriteLine("Số hai");
                //        break;
                //    case 3:
                //        Console.WriteLine("Số ba");
                //        break;
                //    case 4:
                //        Console.WriteLine("Số bốn");
                //        break;
                //    case 5:
                //        Console.WriteLine("Số năm");
                //        break;
                //    case 6:
                //        Console.WriteLine("Số sáu");
                //        break;
                //    case 7:
                //        Console.WriteLine("Số bảy");
                //        break;
                //    case 8:
                //        Console.WriteLine("Số tám");
                //        break;
                //    case 9:
                //        Console.WriteLine("Số chín");
                //        break;
                //    default:
                //        Console.WriteLine("Bạn đã nhập số không hợp lệ");
                //        break;
                //}
                //Console.ReadLine();
               

                        }
            //bai 5


            {
                            Console.ReadLine();

                            Console.WriteLine("Moi ban nhap so a");
                            double a = double.Parse(Console.ReadLine());
                            Console.WriteLine("Moi ban nhap so b");
                            double b = double.Parse(Console.ReadLine());

                            Console.WriteLine("Moi ban nhap phep tinh");
                            char pheptinh = char.Parse(Console.ReadLine());


                            switch (pheptinh)

                            {

                                case '+':
                                    Console.WriteLine("Tong 2 so la {0}", (a + b));
                                    break;
                                case '-':
                                    Console.WriteLine("Hieu 2 so la {0}", a - b);
                                    break;
                                case '*':
                                    Console.WriteLine("Tich 2 so la {0}", a * b);
                                    break;
                                case '/':
                                    if (b != 0)
                                        Console.WriteLine("Thuong 2 so la {0}", a / b);
                                    if (b == 0)
                                        Console.WriteLine("Loi ko thuc hien duoc");

                                    break;
                                case '%':
                                    if (b != 0)
                                        Console.WriteLine("So du cua 2 so la {0}", a % b);
                                    if (b == 0)
                                        Console.WriteLine("Loi ko thuc hien duoc");
                                    break;
                            }
                            Console.ReadLine();
                        }
                    }
                }
            }
    
