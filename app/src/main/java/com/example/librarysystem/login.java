package com.example.librarysystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.pranavpandey.android.dynamic.toasts.DynamicToast;

import java.util.ArrayList;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class login extends AppCompatActivity {
    static int id = 0;
    static ArrayList<Book> books;//creating references for createDB
    static BookList lOB ;
    static ReportList ROB;
    static ArrayList<Account> accounts;
    static AccountList lOA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        createDB();
        createReportList();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    public void login(View v){//login button
        EditText user=(EditText) findViewById(R.id.username);
        EditText pass=(EditText) findViewById(R.id.password);
        String userS=user.getText().toString();
        String passS=pass.getText().toString();//getting user and pass fields

        lOA = lOA.readAccs(getApplicationContext()); //get list of accounts
        accounts = lOA.getAccountList();



         if (userS.equals("admin")) {
             for(int i = 0; i < accounts.size() ; i++){
                 //if there is already a user with the given username then don't make account and give a toast
                 if(userS.equals(accounts.get(i).getUserName()) ){
                     if( passS.equals(accounts.get(i).getPassWord())){
                     Intent intent= new Intent(this, AdminMain.class);
                     startActivity(intent);
                     }else{
                         DynamicToast.makeError(getApplicationContext(), "Password is incorrect").show();
                     }
                 }
             }
        }else{
             for(int i = 0; i < accounts.size() ; i++){
                 //check if there is a user with the username and see if it matches the given
                 if(userS.equals(accounts.get(i).getUserName()) ){
                     //Check if password is equal to the one on the account with correct username
                     if( passS.equals(accounts.get(i).getPassWord())){
                         Intent intent= new Intent(this, UserMain.class);
                         Bundle bundle = new Bundle();
                         bundle.putString("userN" , userS);
                         intent.putExtras(bundle);
                         startActivity(intent);
                         return;
                     }else{
                         DynamicToast.makeError(getApplicationContext(), "Password is incorrect").show();
                     }
                }
             }
             DynamicToast.makeError(getApplicationContext(), "There is no user with the given Username").show();
         }
    }

    public void makeAcc(View v){//make account button
        EditText user=(EditText) findViewById(R.id.username);
        EditText pass=(EditText) findViewById(R.id.password);
        String userS=user.getText().toString();
        String passS=pass.getText().toString();//getting user and pass fields
        lOA = lOA.readAccs(getApplicationContext()); //get list of accounts
        accounts = lOA.getAccountList();
        boolean makeAcc = false;  //if set to true there is already an account with this user so don't make one

        // Customise toast.
        DynamicToast.Config.getInstance()
                .setWarningBackgroundColor(Color.parseColor("#6CE0F3"))
                .apply();


        for(int i = 0; i < accounts.size() ; i++){
            //if there is already a user with the given username then dont make account and give a toast
            if(userS.equals(accounts.get(i).getUserName())){
                DynamicToast.makeWarning(this, "There is already an account with that user name").show();
                makeAcc = true;
            }
        }

        if(userS.isEmpty()){
            DynamicToast.makeWarning(this, "Please enter desired username and password for new account").show();


            // Reset customisations.
            DynamicToast.Config.getInstance().reset();
        } else if(makeAcc == false){
            //If there is no user with the given username than make account and log them in
            Account newA = new Account(userS, passS, false);
            accounts.add(newA);
            lOA = new AccountList(accounts);
            //rewrite the list so it saves with the new account
            lOA.writeAccToFile(lOA, getApplicationContext());
            //pass the user through to the user view
            Intent intent= new Intent(this, UserMain.class);
            Bundle bundle = new Bundle();
            bundle.putString("userN" , userS);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }

    public void createDB() {//if the DB's are not created on device, create DB's with basic fields
        //this will create or read the database's from the file
        books = new ArrayList<Book>();
        accounts = new ArrayList<Account>();

        lOA = lOA.readAccs(getApplicationContext());
        lOB = lOB.read(getApplicationContext());

        ArrayList<Account> listOfAccounts;
        listOfAccounts = lOA.getAccountList();

        ArrayList<Book> listOfBooks;
        listOfBooks = lOB.getBookList();
        // ^ reads the list into listOfBooks, if null which is checked below, make the database and store to file

            if (listOfBooks == null || listOfBooks.isEmpty()) {

                Book book1 = new Book(id, "Catch-22", "Joseph Teller", "War", "Set in Italy during World War II, this is the story of the incomparable, malingering bombardier, Yossarian, a hero who is furious because thousands of people he has never met are trying to kill him. But his real problem is not the enemy—it is his own army, which keeps increasing the number of missions the men must fly to complete their service. Yet if Yossarian makes any attempt to excuse himself from the perilous missions he’s assigned, he’ll be in violation of Catch-22, a hilariously sinister bureaucratic rule: a man is considered insane if he willingly continues to fly dangerous combat missions, but if he makes a formal request to be removed from duty, he is proven sane and therefore ineligible to be relieved.");
                Book book2 = new Book(id, "Lolita", "Vladimir Nabokov", "Romance", "Humbert Humbert - scholar, aesthete and romantic - has fallen completely and utterly in love with Dolores Haze, his landlady's gum-snapping, silky skinned twelve-year-old daughter. Reluctantly agreeing to marry Mrs Haze just to be close to Lolita, Humbert suffers greatly in the pursuit of romance; but when Lo herself starts looking for attention elsewhere, he will carry her off on a desperate cross-country misadventure, all in the name of Love. Hilarious, flamboyant, heart-breaking and full of ingenious word play, Lolita is an immaculate, unforgettable masterpiece of obsession, delusion and lust.");
                Book book3 = new Book(id, "The Great Gatsby", "F. Scott Fitzgerald", "Fiction", "This exemplary novel of the Jazz Age has been acclaimed by generations of readers. The story of the fabulously wealthy Jay Gatsby and his love for the beautiful Daisy Buchanan, of lavish parties on Long Island at a time when The New York Times noted \"gin was the national drink and sex the national obsession,\" it is an exquisitely crafted tale of America in the 1920s.");
                Book book4 = new Book(id, "Invisible Man", "Ralph Ellison", "Race", "As he journeys from the Deep South to the streets and basements of Harlem, from a horrifying \"battle royal\" where black men are reduced to fighting animals, to a Communist rally where they are elevated to the status of trophies, Ralph Ellison's nameless protagonist ushers readers into a parallel universe that throws our own into harsh and even hilarious relief. Suspenseful and sardonic, narrated in a voice that takes in the symphonic range of the American language, black and white, Invisible Man is one of the most audacious and dazzling novels of our century. ");
                Book book5 = new Book(id, "Slaughterhouse-Five", "Kurt Vonnegut Jr.", "Science Fiction", "Selected by the Modern Library as one of the 100 best novels of all time, Slaughterhouse-Five, an American classic, is one of the world's great antiwar books. Centering on the infamous firebombing of Dresden, Billy Pilgrim's odyssey through time reflects the mythic journey of our own fractured lives as we search for meaning in what we fear most.");
                Book book6 = new Book(id, "The Catcher in the Rye", "J.D. Salinger", "Young Adult", "Fleeing the crooks at Pencey Prep, he pinballs around New York City seeking solace in fleeting encounters—shooting the bull with strangers in dive hotels, wandering alone round Central Park, getting beaten up by pimps and cut down by erstwhile girlfriends. The city is beautiful and terrible, in all its neon loneliness and seedy glamour, its mingled sense of possibility and emptiness. Holden passes through it like a ghost, thinking always of his kid sister Phoebe, the only person who really understands him, and his determination to escape the phonies and find a life of true meaning.");
                Book book7 = new Book(id, "The Sound and the Fury", "William Faulkner", "Fiction", "The tragedy of the Compson family features some of the most memorable characters in literature: beautiful, rebellious Caddy; the manchild Benjy; haunted, neurotic Quentin; Jason, the brutal cynic; and Dilsey, their black servant. Their lives fragmented and harrowed by history and legacy, the character’s voices and actions mesh to create what is arguably Faulkner’s masterpiece and one of the greatest novels of the twentieth century.");
                Book book8 = new Book(id, "1984", "George Orwell", "Science Fiction", "The new novel by George Orwell is the major work towards which all his previous writing has pointed. Critics have hailed it as his \"most solid, most brilliant\" work. Though the story of Nineteen Eighty-Four takes place thirty-five years hence, it is in every sense timely. The scene is London, where there has been no new housing since 1950 and where the city-wide slums are called Victory Mansions. Science has abandoned Man for the State. As every citizen knows only too well, war is peace.");
                Book book9 = new Book(id, "Beloved", "Toni Morrison", "Race", "Sethe was born a slave and escaped to Ohio, but eighteen years later she is still not free. She has borne the unthinkable and not gone mad, yet she is still held captive by memories of Sweet Home, the beautiful farm where so many hideous things happened. Meanwhile Sethe’s house has long been troubled by the angry, destructive ghost of her baby, who died nameless and whose tombstone is engraved with a single word: Beloved.");
                Book book10 = new Book(id, "The Grapes of Wrath", "John Steinbeck", "Historical", "First published in 1939, Steinbeck’s Pulitzer Prize-winning epic of the Great Depression chronicles the Dust Bowl migration of the 1930s and tells the story of one Oklahoma farm family, the Joads—driven from their homestead and forced to travel west to the promised land of California. Out of their trials and their repeated collisions against the hard realities of an America divided into Haves and Have-Nots evolves a drama that is intensely human yet majestic in its scale and moral vision, elemental yet plainspoken, tragic but ultimately stirring in its human dignity. A portrait of the conflict between the powerful and the powerless, of one man’s fierce reaction to injustice, and of one woman’s stoical strength, the novel captures the horrors of the Great Depression and probes into the very nature of equality and justice in America. At once a naturalistic epic, captivity narrative, road novel, and transcendental gospel, Steinbeck’s powerful landmark novel is perhaps the most American of American Classics.");
                Book book11 = new Book(id, "To Kill a Mockingbird", "Harper Lee", "Historical", "Compassionate, dramatic, and deeply moving, \"To Kill A Mockingbird\" takes readers to the roots of human behavior - to innocence and experience, kindness and cruelty, love and hatred, humor and pathos. Now with over 18 million copies in print and translated into forty languages, this regional story by a young Alabama woman claims universal appeal. Harper Lee always considered her book to be a simple love story. Today it is regarded as a masterpiece of American literature. ");
                Book book12 = new Book(id, "The Sun Also Rises", "Ernest Hemingway", "Historical", " A poignant look at the disillusionment and angst of the post-World War I generation, the novel introduces two of Hemingway's most unforgettable characters: Jake Barnes and Lady Brett Ashley. The story follows the flamboyant Brett and the hapless Jake as they journey from the wild nightlife of 1920s Paris to the brutal bullfighting rings of Spain with a motley group of expatriates. It is an age of moral bankruptcy, spiritual dissolution, unrealized love, and vanishing illusions.");
                Book book13 = new Book(id, "An American Tragedy", "Theodore Dreiser", "Historical", "'An American Tragedy' is the story of Clyde Griffiths, who spends his life in the desperate pursuit of success. On a deeper, more profound level, it is the masterful portrayal of the society whose values both shape Clyde's ambitions and seal his fate; it is an unsurpassed depiction of the harsh realities of American life and of the dark side of the American dream. Extraordinary in scope and power, vivid in its sense of wholesale human waste, unceasing in its rich compassion, 'An American Tragedy' stands as Theodore Dreiser's supreme achievement.");
                Book book14 = new Book(id, "Atlas Shrugged", "Ayn Rand", "Philosophy", "Why did he have to fight his battle, not against his enemies, but against those who needed him most, and his hardest battle against the woman he loved? What is the world’s motor — and the motive power of every man? You will know the answer to these questions when you discover the reason behind the baffling events that play havoc with the lives of the characters in this story.");
                Book book15 = new Book(id, "Brave New World", "Alduos Huxley", "Science Fiction", "Brave New World is a dystopian novel by English author Aldous Huxley, written in 1931 and published in 1932. Largely set in a futuristic World State, inhabited by genetically modified citizens and an intelligence-based social hierarchy, the novel anticipates huge scientific advancements in reproductive technology, sleep-learning, psychological manipulation and classical conditioning that are combined to make a dystopian society which is challenged by only a single individual: the story's protagonist.");
                Book book16 = new Book(id, "Gone with the Wind", "Margaret Mitchell", "Romance", "Scarlett O'Hara, the beautiful, spoiled daughter of a well-to-do Georgia plantation owner, must use every means at her disposal to claw her way out of the poverty she finds herself in after Sherman's March to the Sea.");
                Book book17 = new Book(id, "Midnight's Children", "Salman Rushdie", "Historical", "Saleem Sinai is born at the stroke of midnight on August 15, 1947, the very moment of India’s independence. Greeted by fireworks displays, cheering crowds, and Prime Minister Nehru himself, Saleem grows up to learn the ominous consequences of this coincidence. His every act is mirrored and magnified in events that sway the course of national affairs; his health and well-being are inextricably bound to those of his nation; his life is inseparable, at times indistinguishable, from the history of his country. Perhaps most remarkable are the telepathic powers linking him with India’s 1,000 other “midnight’s children,” all born in that initial hour and endowed with magical gifts.");
                Book book18 = new Book(id, "My Antonia", "Willa Cather", "Fiction", "Through Jim Burden's endearing, smitten voice, we revisit the remarkable vicissitudes of immigrant life in the Nebraska heartland, with all its insistent bonds. Guiding the way are some of literature's most beguiling characters: the Russian brothers plagued by memories of a fateful sleigh ride, Antonia's desperately homesick father and self-indulgent mother, and the coy Lena Lingard. Holding the pastoral society's heart, of course, is the bewitching, free-spirited Antonia.");
                Book book19 = new Book(id, "On the Road", "Jack Kerouac", "Travel", "A quintessential novel of America & the Beat Generation On the Road chronicles Jack Kerouac's years traveling the N. American continent with his friend Neal Cassady, \"a sideburned hero of the snowy West.\" As \"Sal Paradise\" & \"Dean Moriarty,\" the two roam the country in a quest for self-knowledge & experience. Kerouac's love of America, compassion for humanity & sense of language as jazz combine to make On the Road an inspirational work of lasting importance. This classic novel of freedom & longing defined what it meant to be \"Beat\" & has inspired every generation since its initial publication. ");
                Book book20 = new Book(id, "The Adventures of Huckleberry Finn", "Mark Twain", "Historical", "A nineteenth-century boy from a Mississippi River town recounts his adventures as he travels down the river with a runaway slave, encountering a family involved in a feud, two scoundrels pretending to be royalty, and Tom Sawyer's aunt who mistakes him for Tom.");
                Book book21 = new Book(id, "The Heart is a Lonely Hunter", "Carson McCullers", "Fiction", "Carson McCullers’ prodigious first novel was published to instant acclaim when she was just twenty-three. Set in a small town in the middle of the deep South, it is the story of John Singer, a lonely deaf-mute, and a disparate group of people who are drawn towards his kind, sympathetic nature. The owner of the café where Singer eats every day, a young girl desperate to grow up, an angry drunkard, a frustrated black doctor: each pours their heart out to Singer, their silent confidant, and he in turn changes their disenchanted lives in ways they could never imagine.");
                Book book22 = new Book(id, "The Hitchhiker's Guide to the Galaxy", "Douglas Adams", "Science Fiction", "Seconds before the Earth is demolished to make way for a galactic freeway, Arthur Dent is plucked off the planet by his friend Ford Prefect, a researcher for the revised edition of the The Hitch Hiker's Guide to the Galaxy who, for the last fifteen years, has been posing as an out of work actor.");
                Book book23 = new Book(id, "The Tropic of Cancer", "Henry Miller", "Historical", "Now hailed as an American classic Tropic of Cancer, Henry Miller’s masterpiece, was banned as obscene in this country for twenty-seven years after its first publication in Paris in 1934. Only a historic court ruling that changed American censorship standards, ushering in a new era of freedom and frankness in modern literature, permitted the publication of this first volume of Miller’s famed mixture of memoir and fiction, which chronicles with unapologetic gusto the bawdy adventures of a young expatriate writer, his friends, and the characters they meet in Paris in the 1930s. Tropic of Cancer is now considered, as Norman Mailer said, \"one of the ten or twenty great novels of our century.\"");
                Book book24 = new Book(id, "Their Eyes Were Watching God", "Zora Neale Hurston", "Historical", "Fair and long-legged, independent and articulate, Janie Crawford sets out to be her own person—no mean feat for a black woman in the '30s. Janie's quest for identity takes her through three marriages and into a journey back to her roots.");
                Book book25 = new Book(id, "To the Lighthouse", "Virginia Woolf", "Fiction", "The serene and maternal Mrs. Ramsay, the tragic yet absurd Mr. Ramsay, and their children and assorted guests are on holiday on the Isle of Skye. From the seemingly trivial postponement of a visit to a nearby lighthouse, Woolf constructs a remarkable, moving examination of the complex tensions and allegiances of family life and the conflict between men and women.");
                Book book26 = new Book(id, "Ulysses", "James Joyce", "Fiction", "Loosely based on the Odyssey, this landmark of modern literature follows ordinary Dubliners in 1904. Capturing a single day in the life of Dubliner Leopold Bloom, his friends Buck Mulligan and Stephen Dedalus, his wife Molly, and a scintillating cast of supporting characters, Joyce pushes Celtic lyricism and vulgarity to splendid extremes. Captivating experimental techniques range from interior monologues to exuberant wordplay and earthy humor. A major achievement in 20th century literature.");
                Book book27 = new Book(id, "Moby Dick", "Herman Melville", "Historical", "Moby-Dick; or, The Whale is an 1851 novel by American writer Herman Melville. The book is the sailor Ishmael's narrative of the obsessive quest of Ahab, captain of the whaling ship Pequod, for revenge against Moby Dick, the giant white sperm whale that on the ship's previous voyage bit off Ahab's leg at the knee. ");
                Book book28 = new Book(id, "Dracula", "Bram Stoker", "Horror", "When Jonathan Harker visits Transylvania to help Count Dracula with the purchase of a London house, he makes a series of horrific discoveries about his client. Soon afterwards, various bizarre incidents unfold in England: an apparently unmanned ship is wrecked off the coast of Whitby; a young woman discovers strange puncture marks on her neck; and the inmate of a lunatic asylum raves about the 'Master' and his imminent arrival.");
                Book book29 = new Book(id, "Life of Pi", "Yann Martel", "Adventure", "Life of Pi is a fantasy adventure novel by Yann Martel published in 2001. The protagonist, Piscine Molitor \"Pi\" Patel, a Tamil boy from Pondicherry, explores issues of spirituality and practicality from an early age. He survives 227 days after a shipwreck while stranded on a boat in the Pacific Ocean with a Bengal tiger named Richard Parker.");
                Book book30 = new Book(id, "Heart of Darkness", "Joseph Conrad", "Historical", "It is a story within a story, following a character named Charlie Marlow, who recounts his adventure to a group of men onboard an anchored ship. The story told is of his early life as a ferry boat captain. Although his job was to transport ivory downriver, Charlie develops an interest in investing an ivory procurement agent, Kurtz, who is employed by the government. Preceded by his reputation as a brilliant emissary of progress, Kurtz has now established himself as a god among the natives in “one of the darkest places on earth.” Marlow suspects something else of Kurtz: he has gone mad.");

                books.add(book1);
                books.add(book2);
                books.add(book3);
                books.add(book4);
                books.add(book5);
                books.add(book6);
                books.add(book7);
                books.add(book8);
                books.add(book9);
                books.add(book10);
                books.add(book11);
                books.add(book12);
                books.add(book13);
                books.add(book14);
                books.add(book15);
                books.add(book16);
                books.add(book17);
                books.add(book18);
                books.add(book19);
                books.add(book20);
                books.add(book21);
                books.add(book22);
                books.add(book23);
                books.add(book24);
                books.add(book25);
                books.add(book26);
                books.add(book27);
                books.add(book28);
                books.add(book29);
                books.add(book30);

                lOB = new BookList(books);

                lOB.writeToFile(lOB, getApplicationContext());

            }
            if(listOfAccounts == null ||listOfAccounts.isEmpty()){
                Account admin = new Account("admin", "pass", true);
                Account test = new Account("Test", "TestPass");
                accounts.add(admin);
                accounts.add(test);
                lOA = new AccountList(accounts);
                lOA.writeAccToFile(lOA, getApplicationContext());
                }
        }

    public void createReportList (){




        ROB = ROB.read(getApplicationContext());



        ArrayList<ReportObj> listOfreports;
        listOfreports = ROB.getReportList();

        if (listOfreports ==null||listOfreports.isEmpty()) {
            ROB = new ReportList();
            ROB.writeToFile(ROB, getApplicationContext());
        }
    }
}