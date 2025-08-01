import { Routes, Route, Link } from "react-router-dom";
import Home from "./components/Home";
import About from "./components/About";
import Book from "./components/Book";
import Content from "./components/Content";

const book = [
  {
    id: "1159142",
    title: "Agile Web Development with Rails",
    author: "Sam Ruby, Dave Thomas, David Heinemeier Hansson",
    author_firstname: null,
    author_lastname: "",
    author_middlename: "",
    categories: "Web development",
    volume: "",
    year: "2010",
    edition: "Fourth Edition",
    language: "en",
    extension: "pdf",
    pages: "472",
    filesize: "6937523",
    md5: "AE49D9BB94118632DF0691DF18706319",
    series: "",
    periodical: "",
    file_extension: "pdf",
    url: "http://bookzz.org/dl/1159142/643c75",
    convertTo: {
      epub: "http://bookzz.org/cs2/liveconverter/?source=http%3A%2F%2Fdlx.bookzz.org%2Fgenesis%2F721000%2Fae49d9bb94118632df0691df18706319&input_format=pdf&output_format=EPUB&download=1",
      fb2: "http://bookzz.org/cs2/liveconverter/?source=http%3A%2F%2Fdlx.bookzz.org%2Fgenesis%2F721000%2Fae49d9bb94118632df0691df18706319&input_format=pdf&output_format=FB2&download=1",
      mobi: "http://bookzz.org/cs2/liveconverter/?source=http%3A%2F%2Fdlx.bookzz.org%2Fgenesis%2F721000%2Fae49d9bb94118632df0691df18706319&input_format=pdf&output_format=MOBI&download=1",
      txt: "http://bookzz.org/cs2/liveconverter/?source=http%3A%2F%2Fdlx.bookzz.org%2Fgenesis%2F721000%2Fae49d9bb94118632df0691df18706319&input_format=pdf&output_format=TXT&download=1",
      rtf: "http://bookzz.org/cs2/liveconverter/?source=http%3A%2F%2Fdlx.bookzz.org%2Fgenesis%2F721000%2Fae49d9bb94118632df0691df18706319&input_format=pdf&output_format=RTF&download=1",
    },
    description: "",
    cover:
      "http://libgen.org/covers/721000/ae49d9bb94118632df0691df18706319-g.jpg",
  },
  {
    id: "2375753",
    title: "Flask Web Development",
    author: "Miguel Grinberg",
    author_firstname: null,
    author_lastname: "",
    author_middlename: "",
    categories: "python,pyhton web development,flask",
    volume: "",
    year: "0",
    edition: null,
    language: "",
    extension: "pdf",
    pages: "0",
    filesize: "8864692",
    md5: "d82228cfe8385d6b1e117f87e0c3406f",
    series: "",
    periodical: null,
    file_extension: "pdf",
    url: "http://bookzz.org/dl/2375753/c8da9e",
    convertTo: null,
    description: "",
    cover: null,
  },
  {
    id: "592321",
    title: "Agile web development with rails: a Pragmatic guide",
    author:
      "Dave Thomas, David Heinemeier Hansson, Leon Breedt, Mike Clark, Thomas Fuchs, Andrea Schwarz",
    author_firstname: null,
    author_lastname: "",
    author_middlename: "",
    categories:
      "'Web site development -- Handbooks, manuals, etc.','Ruby (Computer program language) -- Handbooks, manuals, etc.','Sites Web -- DeРњРѓveloppement -- Guides, manuels, etc.','Ruby (Langage de programmation) -- Guides, manuels, etc.'",
    volume: "",
    year: "2005",
    edition: "1",
    language: "en",
    extension: "pdf",
    pages: "554",
    filesize: "7990657",
    md5: "AF5F2F07C3BF2FD005FC4189B6945FEB",
    series: "Pragmatic Programmers",
    periodical: "",
    file_extension: "pdf",
    url: "http://bookzz.org/dl/592321/c1094c",
    convertTo: null,
    description:
      "Rails is a full-stack, open source web framework that enables you to create full-featured, sophisticated web-based applications, but with a twist... A full Rails application probably has less total code than the XML you'd need to configure the same application in other frameworks. With this book you'll learn how to use \"ActiveRecord\" to connect business objects and database tables. No more painful object-relational mapping. Just create your business objects and let Rails do the rest. You'll learn how to use the \"Action Pack\" framework to route incoming requests and render pages using easy-to-write templates and components. See how to exploit the Rails service frameworks to send emails, implement web services, and create dynamic, user-centric web-pages using built-in Javascript and Ajax support. There are extensive chapters on testing, deployment, and scaling. You'll see how easy it is to install Rails using your web server of choice (such as Apache or lighttpd) or using its own included web server. You'll be writing applications that work with your favorite database (MySQL, Oracle, Postgres, and more) in no time at all. You'll create a complete online store application in the extended tutorial section, so you'll see how a full Rails application is developed---iteratively and rapidly. Rails strives to honor the Pragmatic Programmer's \"DRY Principle\" by avoiding the extra work of configuration files and code annotations. You can develop in real-time: make a change, and watch it work immediately. Forget XML. Everything in Rails, from templates to control flow to business logic, is written in Ruby, the language of choice for programmers who like to get the job done well (and leave work ontime for a change). Rails is the framework of choice for the new generation of Web 2.0 developers. Agile Web Development with Rails is the book for that generation, written by Dave Thomas (Pragmatic Programmer and author of Programming Ruby) and David Heinemeier Hansson, who created Rails.",
    cover:
      "http://libgen.org/covers/164000/af5f2f07c3bf2fd005fc4189b6945feb-d.jpg",
  },
  {
    id: "643503",
    title:
      "CakePHP Application Development: Step-by-step introduction to rapid web development using the open-source MVC CakePHP framework",
    author: "Ahsanul Bari, Anupom Syam",
    author_firstname: null,
    author_lastname: "",
    author_middlename: "",
    categories: "Computer Science/Web/Server Side Scripting/PHP",
    volume: "",
    year: "2008",
    edition: "",
    language: "en",
    extension: "pdf",
    pages: "328",
    filesize: "9179016",
    md5: "0130DD963CCA48D57BFE2252C2A521F7",
    series: "",
    periodical: "",
    file_extension: "pdf",
    url: "http://bookzz.org/dl/643503/4ed37c",
    convertTo: null,
    description:
      "I bought this book based on the reviews here. It was the highest rated CakePHP book on Amazon at the time so I figured I couldn't go wrong. I was a little wrong about that...\r\rThe book is pretty easy to follow, and it does a good job introducing you to how CakePHP works and talking you through using the MVC pattern. The reason I gave it such a low rating is because of the code typos that litter the pages and all of the terrible, terrible grammar throughout. It's as though the author didn't speak English natively and the editors didn't bother to fix anything! What's worse, some of the concepts in the book are stated exactly backwards; a read headache for the beginner.\r\rIf you already know PHP to some degree and are at least familiar with CakePHP, the book is pretty helpful for solidifying ideas. It's probably one of the better books I've read on the topic in terms of the order in which they teach you and how it's described. But, if you're new to PHP or CakePHP, don't start with this book; you'll be pulling your hair out trying to figure out where the typos in the code are and interpreting the text.\r\rOverall, I'm happy I picked the book up. It's the second one I've been reading and it's helped me make more sense of how some of the components work, but if you're new and you just want to learn how to use CakePHP, you should consider looking elsewhere, or at least reading The Manual on their website first.",
    cover:
      "http://libgen.org/covers/215000/0130dd963cca48d57bfe2252c2a521f7-d.jpg",
  },
  {
    id: "547307",
    title: "Alex Homer, ASP.NET 2.0 Visual Web Developer 2005",
    author: "David Sussman",
    author_firstname: null,
    author_lastname: "",
    author_middlename: "",
    categories:
      "Компьютерная литература\\11 web строительство\\Web - строительство, ASP.NET\\",
    volume: "",
    year: "2006",
    edition: "",
    language: "en",
    extension: "pdf",
    pages: "314",
    filesize: "13218370",
    md5: "F317BC40EC89D98E867B2099C4341A68",
    series: "",
    periodical: "",
    file_extension: "pdf",
    url: "http://bookzz.org/dl/547307/7e39f2",
    convertTo: null,
    description:
      "*  This Starter Kit serves as an entry-level introduction centered around prebuilt projects that developers can easily deploy and customize for their own sites    * Explains how to build good basic Web sites, including design and architecture, for users who plan to build more complex sites in the future    * Details the key site features that beginners like to implement, including catalogs, shopping carts, images, and secure site sections    * The authors use very little code, but where coding is needed, they feature the simple Visual Basic language    * The CD-ROM includes Visual Web Developer 2005 Express Edition",
    cover:
      "http://libgen.org/covers/119000/f317bc40ec89d98e867b2099c4341a68.jpg",
  },
  {
    id: "643519",
    title:
      "PHP Oracle Web Development: Data processing, Security, Caching, XML, Web Services, and Ajax: A practical guide to combining the power, performance, scalability, ... time, and high performance of PHP",
    author: "Yuli Vasiliev",
    author_firstname: null,
    author_lastname: "",
    author_middlename: "",
    categories: "Computer Science/Web/Server Side Scripting/PHP",
    volume: "",
    year: "2007",
    edition: "1st Ed.",
    language: "en",
    extension: "pdf",
    pages: "392",
    filesize: "7257933",
    md5: "D930B9CE10509818A14659BC607DAB78",
    series: "",
    periodical: "",
    file_extension: "pdf",
    url: "http://bookzz.org/dl/643519/5e54d0",
    convertTo: {
      epub: "http://bookzz.org/cs2/liveconverter/?source=http%3A%2F%2Fdlx.bookzz.org%2Fgenesis%2F215000%2Fd930b9ce10509818a14659bc607dab78&input_format=pdf&output_format=EPUB&download=1",
      fb2: "http://bookzz.org/cs2/liveconverter/?source=http%3A%2F%2Fdlx.bookzz.org%2Fgenesis%2F215000%2Fd930b9ce10509818a14659bc607dab78&input_format=pdf&output_format=FB2&download=1",
      mobi: "http://bookzz.org/cs2/liveconverter/?source=http%3A%2F%2Fdlx.bookzz.org%2Fgenesis%2F215000%2Fd930b9ce10509818a14659bc607dab78&input_format=pdf&output_format=MOBI&download=1",
      txt: "http://bookzz.org/cs2/liveconverter/?source=http%3A%2F%2Fdlx.bookzz.org%2Fgenesis%2F215000%2Fd930b9ce10509818a14659bc607dab78&input_format=pdf&output_format=TXT&download=1",
      rtf: "http://bookzz.org/cs2/liveconverter/?source=http%3A%2F%2Fdlx.bookzz.org%2Fgenesis%2F215000%2Fd930b9ce10509818a14659bc607dab78&input_format=pdf&output_format=RTF&download=1",
    },
    description:
      "Based on the title, the book has so many things to discuss but it actually has less than 400 pages that even include the glossary of terms. The reader might have a second thought about the book since it might not promise to discuss the things written in the chapter.\r\rBut if you go through the chapters, you will be surprised how each topic could be discussed thoroughly in this book. Using the traditional structures in most web and application development books, it slowly introduces each concept before they are brought together in the final chapters. \r\rPHP and Oracle are discussed separately at first with sample codes and situations to ensure that the reader understands each concept. It then goes to discuss who they could be efficiently integrated. The final chapter which is about Ajax is very impressive as it gives the developers a chance to develop an Ajax based application using popular practices in web development. The robustness of Oracle and efficiency of PHP is actually shown in an Ajax based application.\r\rPHP Oracle Web Development: Data processing, Security, Caching, XML, Web Services, and Ajax is a good starting book for any web development professionals and enthusiasts. It covers the basics of web development using PHP and database management of Oracle including an installation guide for Oracle and PHP. If you are looking for a book to start with PHP and Oracle, this book offers a good start. \r\rFor developers who are experienced in this discipline, the book could be a good reference point for developing an application. The sample codes that helps the reader understands the underlying concept of the application with actual scenarios, this PHP and Oracle book is almost too good to pass on.",
    cover:
      "http://libgen.org/covers/215000/d930b9ce10509818a14659bc607dab78-d.jpg",
  },
];

const bookList = book.map((book) => {
  return {
    id: book.id,
    title: book.title,
    author: book.author,
    year: book.year,
    categories: book.categories,
    cover: book.cover,
  };
});

function App() {
  return (
    <div className="wrap">
      <h1>도서 정보 사이트</h1>
      <ul>
        <li>
          <Link to="/">Home</Link>
        </li>
        <li>
          <Link to="/About">About</Link>
        </li>
        <li>
          <Link to="/Book">Book</Link>
        </li>
        <li>
          <Link to="/Content">도서목록</Link>
        </li>
      </ul>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/About" element={<About />} />
        <Route
          path="/Book/:book_id"
          element={
            <Book
              onFind={(id) => {
                //book : 도서 전체 정보 배열
                return book.find((item) => item.id === id);
              }}
            />
          }
        />
        <Route path="/Content" element={<Content book_list={bookList} />} />
      </Routes>
    </div>
  );
}

export default App;
