/**
 * @path TP02Q02 - Classe em C/pokemon.c
 * @description C file that implements the pokemon class.
 * @author Pedro Lopes - github.com/httpspedroh
 * @version 2.0
 * @update 2024-04-09
 */

// ---------------------------------------------------------------------------------------------------- //

// Includes
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

// ---------------------------------------------------------------------------------------------------- //

// Constants
#define MAX_pokemonS 805
#define FILE_PATH "/tmp/pokemon.csv"

#define MAX_UUID_SIZE 37
#define MAX_NAME_SIZE 30
#define MAX_ALTERNATE_NAMES 10
#define MAX_ALTERNATE_NAME_SIZE 35
#define MAX_HOUSE_SIZE 15
#define MAX_ANCESTRY_SIZE 15
#define MAX_SPECIES_SIZE 20
#define MAX_PATRONUS_SIZE 25
#define MAX_ACTOR_NAME_SIZE 35
#define MAX_EYE_COLOUR_SIZE 10
#define MAX_GENDER_SIZE 10
#define MAX_HAIR_COLOUR_SIZE 10

#define MAX_LINE_SIZE 300

// ---------------------------------------------------------------------------------------------------- //

// Structs
typedef struct Date {
    int day;
    int month;
    int year;
} Date;

typedef struct Pokemon {

    int id;
    int generation;
    char *name;
    char *description;
    
    char *types[MAX_ALTERNATE_NAMES];
    char *abilities[MAX_ALTERNATE_NAMES];

    double weight;
    double height;
    int captureRate;
    bool isLegendary;
    Date captureDate;
} Pokemon;

// ---------------------------------------------------------------------------------------------------- //

// Global variables
Pokemon pokemons[MAX_pokemonS];
int pokemonsLength = 0;



// ---------------------------------------------------------------------------------------------------- //

// Functions
bool isEnd(char* line) { return line[0] == 'F' && line[1] == 'I' && line[2] == 'M'; }

void substring(char *string, char *stringStart, int length) {

    strncpy(string, stringStart, length);
    string[length] = '\0';
}

void proccess_attribute(char *attribute, char **substringStart, char **substringEnd, bool isFirstAttribute, bool isStringArray) {

    // Skip first comma
    if(!isFirstAttribute) {

        if(*substringEnd != NULL) *substringStart = *substringEnd + 1;
        else *substringStart = *substringEnd;
    }

    if(!isStringArray) {

        if((*substringStart)[0] == '"') {

            *substringStart = *substringStart + 1;
            *substringEnd = strchr(*substringStart, '"');
        }
        else *substringEnd = strchr(*substringStart, ';');

        // Get substring
        if(*substringEnd) {

            substring(attribute, *substringStart, *substringEnd - *substringStart);

            if(*substringEnd[0] == '"') *substringEnd = *substringEnd + 1;
        }
        else strcpy(attribute, *substringStart);

        // Set default value if attribute is empty
        if(strcmp(attribute, "") == 0 || attribute[0] == '\n' || attribute[0] == '\r' || attribute[0] == '\0') strcpy(attribute, "N/A");

        // Clean \n from the end of the string
        if(attribute[strlen(attribute) - 1] == '\n' || attribute[strlen(attribute) - 1] == '\r') attribute[strlen(attribute) - 1] = '\0';
    }
    else {

        // Check if the first pokemon is a [
        if((*substringStart)[0] == '[') {

            *substringStart = *substringStart + 1;

            if((*substringStart)[0] == ']') strcpy(attribute, ""); // Case: []
            else {

                char *tempConcat = (char *) calloc(MAX_LINE_SIZE, sizeof(char));

                *substringStart = *substringStart - 1;

                while(1) {

                    *substringStart = *substringStart + 1;

                    if((*substringStart)[0] == ';') break;
                    else if((*substringStart)[0] == '\'') { // Case: "['example', 'example']"

                        *substringStart = *substringStart + 1;
                        *substringEnd = strchr(*substringStart, '\'');

                        // Get substring
                        if(*substringEnd) {

                            // Create tmp name
                            char tmp[MAX_LINE_SIZE];
                            substring(tmp, *substringStart, *substringEnd - *substringStart);

                            // Concat tempConcat with tmp
                            strcat(tempConcat, tmp);
                            strcat(tempConcat, ", ");

                            *substringStart = *substringEnd + 1;
                        }
                    }
                }

                // Get substring
                strcpy(attribute, tempConcat);

                // Clean "attribute" removing last 2 pokemon
                attribute[strlen(attribute) - 2] = '\0';
            }
        }

        *substringEnd = strchr(*substringStart, ';');
    }
}

// ---------------------------------------------------------------------------------------------------- //

// Methods implementations

// Gets
int pokemon_getId(Pokemon *pokemon) { return pokemon -> id; }
int pokemon_getGeneration(Pokemon *pokemon) { return pokemon -> generation }
char *pokemon_getName(Pokemon *pokemon) { return pokemon -> name; }
char *pokemon_getDescription(Pokemon *pokemon) { return pokemon -> description; }
double pokemon_getWeight(Pokemon *pokemon) { return pokemon -> weight }
double pokemon_getHeight(Pokemon *pokemon) { return pokemon -> height }
int pokemon_getCaptureRate(Pokemon *pokemon) { return pokemon -> captureRate }
bool pokemon_getLegendary(Pokemon *pokemon) { return pokemon -> isLegendary }

char *pokemon_getCaptureDate(Pokemon *pokemon) {

    // "N/A" if day, month and year are -1
    char *captureDate = (char *) calloc(15, sizeof(char));
    strcpy(captureDate, "N/A");

    if(pokemon -> captureDate.day != -1 && pokemon -> captureDate.month != -1 && pokemon -> captureDate.year != -1) {

        sprintf(captureDate, "%02d-%02d-%04d", pokemon -> captureDate.day, pokemon -> captureDate.month, pokemon -> captureDate.year);
    }

    return captureDate;
}

char *pokemon_getTypes(Pokemon *pokemon) {

    // Concatenate all alternate names with a comma
    char *types = (char *) calloc(MAX_ALTERNATE_NAME_SIZE * MAX_ALTERNATE_NAMES, sizeof(char));

    types[0] = '{';

    for(int i = 0; i < MAX_ALTERNATE_NAMES; i++) {

        if(strcmp(pokemon -> types[i], "") != 0) {

            strcat(types, pokemon -> types[i]);

            if(strcmp(pokemon -> types[i + 1], "") != 0) strcat(types, ", ");
        }
    }

    strcat(types, "}");

    return types;
}

char *pokemon_getAbilities(Pokemon *pokemon) {

    // Concatenate all alternate names with a comma
    char *abilities = (char *) calloc(MAX_ALTERNATE_NAME_SIZE * MAX_ALTERNATE_NAMES, sizeof(char));

    abilities[0] = '{';

    for(int i = 0; i < MAX_ALTERNATE_NAMES; i++) {

        if(strcmp(pokemon -> abilities[i], "") != 0) {

            strcat(abilities, pokemon -> abilities[i]);

            if(strcmp(pokemon -> abilities[i + 1], "") != 0) strcat(abilities, ", ");
        }
    }

    strcat(abilities, "}");

    return abilities;
}

// Sets
void pokemon_setId(Pokemon *pokemon, int id) { strcpy(pokemon -> id, id); }
void pokemon_setGeneration(Pokemon *pokemon, int generation) { strcpy(pokemon -> generation, generation); }
void pokemon_setName(Pokemon *pokemon, char *name) { strcpy(pokemon -> name, name); }


void pokemon_setHouse(Pokemon *pokemon, char *house) { strcpy(pokemon -> house, house); }
void pokemon_setAncestry(Pokemon *pokemon, char *ancestry) { strcpy(pokemon -> ancestry, ancestry); }
void pokemon_setSpecies(Pokemon *pokemon, char *species) { strcpy(pokemon -> species, species); }
void pokemon_setPatronus(Pokemon *pokemon, char *patronus) { strcpy(pokemon -> patronus, patronus); }
void pokemon_setHogwartsStaff(Pokemon *pokemon, bool hogwartsStaff) { pokemon -> hogwartsStaff = hogwartsStaff; }
void pokemon_setHogwartsStudent(Pokemon *pokemon, bool hogwartsStudent) { pokemon -> hogwartsStudent = hogwartsStudent; }
void pokemon_setActorName(Pokemon *pokemon, char *actorName) { strcpy(pokemon -> actorName, actorName); }
void pokemon_setAlive(Pokemon *pokemon, bool alive) { pokemon -> alive = alive; }
void pokemon_setYearOfcapture(Pokemon *pokemon, int yearOfcapture) { pokemon -> yearOfcapture = yearOfcapture; }
void pokemon_setEyeColour(Pokemon *pokemon, char *eyeColour) { strcpy(pokemon -> eyeColour, eyeColour); }
void pokemon_setGender(Pokemon *pokemon, char *gender) { strcpy(pokemon -> gender, gender); }
void pokemon_setHairColour(Pokemon *pokemon, char *hairColour) { strcpy(pokemon -> hairColour, hairColour); }
void pokemon_setWizard(Pokemon *pokemon, bool wizard) { pokemon -> wizard = wizard; }

void pokemon_setcaptureDate(Pokemon *pokemon, char *captureDate) {

    // Explode captureDate in format DD-MM-YYYY if in format DD-MM-YYYY
    if(strlen(captureDate) >= 8 && strlen(captureDate) <= 10) {

        char *token = strtok(captureDate, "-");

        pokemon -> captureDate.day = atoi(token);
        token = strtok(NULL, "-");
        pokemon -> captureDate.month = atoi(token);
        token = strtok(NULL, "-");
        pokemon -> captureDate.year = atoi(token);
    }
}

void pokemon_setTypes(Pokemon *pokemon, char *types) {

    // Copy names to a temporary variable
    char tempTypes[MAX_ALTERNATE_NAME_SIZE * MAX_ALTERNATE_NAMES];
    strcpy(tempTypes, types);

    // Separate names by comma
    char *token = strtok(tempTypes, ",");
    int i = 0;

    // Copy names to the pokemon
    while (token != NULL && i < MAX_ALTERNATE_NAMES) {

        while (*token == ' ') token++;

        int len = strlen(token);

        while (len > 0 && token[len - 1] == ' ') {

            token[len - 1] = '\0';
            len--;
        }

        strcpy(pokemon -> types[i++], token);
        token = strtok(NULL, ",");
    }
}

void pokemon_setAbilities(Pokemon *pokemon, char *abilities) {

    // Copy names to a temporary variable
    char tempAbilities[MAX_ALTERNATE_NAME_SIZE * MAX_ALTERNATE_NAMES];
    strcpy(tempAbilities, abilities);

    // Separate names by comma
    char *token = strtok(tempAbilities, ",");
    int i = 0;

    // Copy names to the pokemon
    while (token != NULL && i < MAX_ALTERNATE_NAMES) {

        while (*token == ' ') token++;

        int len = strlen(token);

        while (len > 0 && token[len - 1] == ' ') {

            token[len - 1] = '\0';
            len--;
        }

        strcpy(pokemon -> abilities[i++], token);
        token = strtok(NULL, ",");

    }

}

// Class
Pokemon pokemon_newBlank() {

    Pokemon pokemon;

    pokemon.id = (char *) calloc(MAX_UUID_SIZE, sizeof(char));
    strcpy(pokemon.id, "");

    pokemon.name = (char *) calloc(MAX_NAME_SIZE, sizeof(char));
    strcpy(pokemon.name, "");

    for(int i = 0; i < MAX_ALTERNATE_NAMES; i++) {

        pokemon.types[i] = (char *) calloc(MAX_ALTERNATE_NAME_SIZE, sizeof(char));
        strcpy(pokemon.types[i], "");
    }

    pokemon.house = (char *) calloc(MAX_HOUSE_SIZE, sizeof(char));
    strcpy(pokemon.house, "");

    pokemon.ancestry = (char *) calloc(MAX_ANCESTRY_SIZE, sizeof(char));
    strcpy(pokemon.ancestry, "");

    pokemon.species = (char *) calloc(MAX_SPECIES_SIZE, sizeof(char));
    strcpy(pokemon.species, "");

    pokemon.patronus = (char *) calloc(MAX_PATRONUS_SIZE, sizeof(char));
    strcpy(pokemon.patronus, "");

    pokemon.hogwartsStaff = false;
    pokemon.hogwartsStudent = false;

    pokemon.actorName = (char *) calloc(MAX_ACTOR_NAME_SIZE, sizeof(char));
    strcpy(pokemon.actorName, "");

    pokemon.alive = false;

    pokemon.captureDate.day = -1;
    pokemon.captureDate.month = -1;
    pokemon.captureDate.year = -1;

    pokemon.yearOfcapture = -1;

    pokemon.eyeColour = (char *) calloc(MAX_EYE_COLOUR_SIZE, sizeof(char));
    strcpy(pokemon.eyeColour, "");

    pokemon.gender = (char *) calloc(MAX_GENDER_SIZE, sizeof(char));
    strcpy(pokemon.gender, "");

    pokemon.hairColour = (char *) calloc(MAX_HAIR_COLOUR_SIZE, sizeof(char));
    strcpy(pokemon.hairColour, "");

    pokemon.wizard = false;

    return pokemon;
}

Pokemon pokemon_new(char *id, char *name, char *house, char *ancestry, char *species, char *patronus, bool hogwartsStaff, bool hogwartsStudent, char *actorName, bool alive, Date captureDate, int yearOfcapture, char *eyeColour, char *gender, char *hairColour, bool wizard) {

    Pokemon pokemon;

    pokemon.id = (char *) calloc(MAX_UUID_SIZE, sizeof(char));
    strcpy(pokemon.id, id);

    pokemon.name = (char *) calloc(MAX_NAME_SIZE, sizeof(char));
    strcpy(pokemon.name, name);

    for(int i = 0; i < MAX_ALTERNATE_NAMES; i++) {

        pokemon.types[i] = (char *) calloc(MAX_ALTERNATE_NAME_SIZE, sizeof(char));
        strcpy(pokemon.types[i], "");
    }

    pokemon.house = (char *) calloc(MAX_HOUSE_SIZE, sizeof(char));
    strcpy(pokemon.house, house);

    pokemon.ancestry = (char *) calloc(MAX_ANCESTRY_SIZE, sizeof(char));
    strcpy(pokemon.ancestry, ancestry);

    pokemon.species = (char *) calloc(MAX_SPECIES_SIZE, sizeof(char));
    strcpy(pokemon.species, species);

    pokemon.patronus = (char *) calloc(MAX_PATRONUS_SIZE, sizeof(char));
    strcpy(pokemon.patronus, patronus);

    pokemon.hogwartsStaff = hogwartsStaff;
    pokemon.hogwartsStudent = hogwartsStudent;

    pokemon.actorName = (char *) calloc(MAX_ACTOR_NAME_SIZE, sizeof(char));
    strcpy(pokemon.actorName, actorName);

    pokemon.alive = alive;
    pokemon.captureDate = captureDate;
    pokemon.yearOfcapture = yearOfcapture;

    pokemon.eyeColour = (char *) calloc(MAX_EYE_COLOUR_SIZE, sizeof(char));
    strcpy(pokemon.eyeColour, eyeColour);

    pokemon.gender = (char *) calloc(MAX_GENDER_SIZE, sizeof(char));
    strcpy(pokemon.gender, gender);

    pokemon.hairColour = (char *) calloc(MAX_HAIR_COLOUR_SIZE, sizeof(char));
    strcpy(pokemon.hairColour, hairColour);

    pokemon.wizard = wizard;

    return pokemon;
}

Pokemon *pokemon_clone(Pokemon *pokemon) {

    Pokemon *clone = (Pokemon *) malloc(sizeof(Pokemon));

    clone -> id = (char *) calloc(MAX_UUID_SIZE, sizeof(char));
    strcpy(clone -> id, pokemon -> id);

    clone -> name = (char *) calloc(MAX_NAME_SIZE, sizeof(char));
    strcpy(clone -> name, pokemon -> name);

    for(int i = 0; i < MAX_ALTERNATE_NAMES; i++) {

        clone -> types[i] = (char *) calloc(MAX_ALTERNATE_NAME_SIZE, sizeof(char));
        strcpy(clone -> types[i], pokemon -> types[i]);
    }

    clone -> house = (char *) calloc(MAX_HOUSE_SIZE, sizeof(char));
    strcpy(clone -> house, pokemon -> house);

    clone -> ancestry = (char *) calloc(MAX_ANCESTRY_SIZE, sizeof(char));
    strcpy(clone -> ancestry, pokemon -> ancestry);

    clone -> species = (char *) calloc(MAX_SPECIES_SIZE, sizeof(char));
    strcpy(clone -> species, pokemon -> species);

    clone -> patronus = (char *) calloc(MAX_PATRONUS_SIZE, sizeof(char));
    strcpy(clone -> patronus, pokemon -> patronus);

    clone -> hogwartsStaff = pokemon -> hogwartsStaff;
    clone -> hogwartsStudent = pokemon -> hogwartsStudent;

    clone -> actorName = (char *) calloc(MAX_ACTOR_NAME_SIZE, sizeof(char));
    strcpy(clone -> actorName, pokemon -> actorName);

    clone -> alive = pokemon -> alive;
    clone -> captureDate = pokemon -> captureDate;
    clone -> yearOfcapture = pokemon -> yearOfcapture;

    clone -> eyeColour = (char *) calloc(MAX_EYE_COLOUR_SIZE, sizeof(char));
    strcpy(clone -> eyeColour, pokemon -> eyeColour);

    clone -> gender = (char *) calloc(MAX_GENDER_SIZE, sizeof(char));
    strcpy(clone -> gender, pokemon -> gender);

    clone -> hairColour = (char *) calloc(MAX_HAIR_COLOUR_SIZE, sizeof(char));
    strcpy(clone -> hairColour, pokemon -> hairColour);

    clone -> wizard = pokemon -> wizard;

    return clone;
}

void pokemon_print(Pokemon *pokemon) {

    printf("[%s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s]\n",

        pokemon_getId(pokemon),
        pokemon_getName(pokemon),
        pokemon_gettypes(pokemon),
        pokemon_getHouse(pokemon),
        pokemon_getAncestry(pokemon),
        pokemon_getSpecies(pokemon),
        pokemon_getPatronus(pokemon),
        pokemon_getHogwartsStaff(pokemon) ? "true" : "false",
        pokemon_getHogwartsStudent(pokemon) ? "true" : "false",
        pokemon_getActorName(pokemon),
        pokemon_getAlive(pokemon) ? "true" : "false",
        pokemon_getcaptureDate(pokemon),
        pokemon_getYearOfcapture(pokemon),
        pokemon_getEyeColour(pokemon),
        pokemon_getGender(pokemon),
        pokemon_getHairColour(pokemon),
        pokemon_getWizard(pokemon) ? "true" : "false"
        );
}

Pokemon pokemon_read(char *line) {

    Pokemon pokemon = pokemon_newBlank();

    char *substringStart = line;
    char *substringEnd = NULL;
    char attribute[MAX_LINE_SIZE];

    // Get id
    proccess_attribute(attribute, &substringStart, &substringEnd, true, false);
    pokemon_setId(&pokemon, attribute);

    // Get name
    proccess_attribute(attribute, &substringStart, &substringEnd, false, false);
    pokemon_setName(&pokemon, attribute);

    // Get alternate names
    proccess_attribute(attribute, &substringStart, &substringEnd, false, true);
    pokemon_settypes(&pokemon, attribute);

    // Get house
    proccess_attribute(attribute, &substringStart, &substringEnd, false, false);
    pokemon_setHouse(&pokemon, attribute);

    // Get ancestry
    proccess_attribute(attribute, &substringStart, &substringEnd, false, false);
    pokemon_setAncestry(&pokemon, attribute);

    // Get species
    proccess_attribute(attribute, &substringStart, &substringEnd, false, false);
    pokemon_setSpecies(&pokemon, attribute);

    // Get patronus
    proccess_attribute(attribute, &substringStart, &substringEnd, false, false);
    pokemon_setPatronus(&pokemon, attribute);

    // Get hogwarts staff
    proccess_attribute(attribute, &substringStart, &substringEnd, false, false);
    pokemon_setHogwartsStaff(&pokemon, strcmp(attribute, "VERDADEIRO") == 0);

    // Get hogwarts student
    proccess_attribute(attribute, &substringStart, &substringEnd, false, false);
    pokemon_setHogwartsStudent(&pokemon, strcmp(attribute, "VERDADEIRO") == 0);

    // Get actor name
    proccess_attribute(attribute, &substringStart, &substringEnd, false, false);
    pokemon_setActorName(&pokemon, attribute);

    // Get alive
    proccess_attribute(attribute, &substringStart, &substringEnd, false, false);
    pokemon_setAlive(&pokemon, strcmp(attribute, "VERDADEIRO") == 0);

    // Get capture date
    proccess_attribute(attribute, &substringStart, &substringEnd, false, false);
    pokemon_setcaptureDate(&pokemon, attribute);

    // Get year of capture
    proccess_attribute(attribute, &substringStart, &substringEnd, false, false);
    pokemon_setYearOfcapture(&pokemon, atoi(attribute) == 0 ? -1 : atoi(attribute));

    // Get eye colour
    proccess_attribute(attribute, &substringStart, &substringEnd, false, false);
    pokemon_setEyeColour(&pokemon, attribute);

    // Get gender
    proccess_attribute(attribute, &substringStart, &substringEnd, false, false);
    pokemon_setGender(&pokemon, attribute);

    // Get hair colour
    proccess_attribute(attribute, &substringStart, &substringEnd, false, false);
    pokemon_setHairColour(&pokemon, attribute);

    // Get wizard
    proccess_attribute(attribute, &substringStart, &substringEnd, false, false);

    // Clean \n from the end of the string
    if(attribute[strlen(attribute) - 1] == '\n' || attribute[strlen(attribute) - 1] == '\r') attribute[strlen(attribute) - 1] = '\0';

    pokemon_setWizard(&pokemon, strcmp(attribute, "VERDADEIRO") == 0);
    return pokemon;
}

Pokemon *pokemon_searchById(char *id) {

    for(int i = 0; i < pokemonsLength; i++) {

        if(!strcmp(pokemons[i].id, id)) return &pokemons[i];
    }
    return NULL;
}

// General
void startpokemons() {

    // Open file
    FILE *fp;
    char *line = NULL;
    size_t len = 0;
    ssize_t read;

    fp = fopen(FILE_PATH, "r");

    if(fp == NULL) {

        perror("x Error opening file");
        exit(EXIT_FAILURE);
    }

    // Skip first line
    getline(&line, &len, fp);

    // Read all lines
    while((read = getline(&line, &len, fp)) != -1) {

        // Read pokemon from line
        Pokemon pokemon = pokemon_read(line);

        pokemons[pokemonsLength++] = pokemon;

        if(pokemonsLength >= MAX_pokemonS) {

            perror("x Max pokemons reached");
            exit(EXIT_FAILURE);
        }
    }

    // Close file and free memory
    fclose(fp);

    if(line) free(line);
}

// ---------------------------------------------------------------------------------------------------- //



int main()
{
    printf("Hello world!\n");
    return 0;
}
