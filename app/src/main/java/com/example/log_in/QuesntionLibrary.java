package com.example.log_in;

public class QuesntionLibrary {
    private String mQuesntions[] = {
            // Will not admit question
            "Is the resident with intravenous Line?",
            "Is the resident NOT assessed by DHB?",
            "Is the resident having severe agitation like punchiong, spitting, or any behavior that cannot be managed by medication?",
            "Does the resident have dementia and there is no Especial Power of Attoney (EPOA)",
            //Dementia care question
            "Does the resident have wandering behavior?",
            "Is the resident asking the the questions in 1 day?",
            "Is the resident decreasing weight?",
            "Is the resident ablt to walk but with minimal supervision?",
            //Hospital care
            "Is the resident unvbale to walk?",
            "Is the resident Poly-pharmacy (medication more than 10)?",
            "Is the resident with presure injury?",
            "Is the resident frequently hospotalized?",
            //Rest-home care question
            "Can walk independently ot with walker?",
            "Can handle conversations?",
            "Can feed themselves, no swallowing issues?",
            "Can answer exact time, date, location, birthday, family background?"};

    public String getQuestion(int a) {
        String question = mQuesntions[a];
        return question;
    }
}
