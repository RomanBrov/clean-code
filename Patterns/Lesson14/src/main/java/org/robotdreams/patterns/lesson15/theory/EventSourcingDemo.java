package org.robotdreams.patterns.lesson15.theory;

public class EventSourcingDemo {

    // CreateDocument("my speech", folderRef, userRef)          | INSERT <my xml/>
    // InsertText("speech by ... at development conference")    | UPDATE <my xml > my text </>
    // InsertText("Text 1")                                | UPDATE <my xml > my text </>
    // InsertText("Text 3", u2)                                | UPDATE <my xml > my text2 </>
    // InsertText("Text 2", u1)                                | UPDATE <my xml > my text1 </>
    // ApplyFormatting(style: P1, selection)                    | UPDATE <my xml > <style 25> my text </style> </>
    // ApplyFormatting(style: P2, selection)
    // Save To Disk -> XML (Snapshot)
    // Load from Disk <- XML
    // InsertText("Text 4")
    // DeleteSelection(..)
    // ..

        /*
        <document>
        ..
        <insert by="Sasha" date="2022-09-01" time="20:13:00">
        <style P1>
        speech by ... at development conference
        </style>
        </insert>
        </document>
         */
}

// Eventual consistency

