import requests
import urllib

APP_ID = "30ccd393"
APP_KEYS = "bd712aef489acbcfd24a515b6e18fb08"
URL = f'https://api.edamam.com/search?/app_id=${APP_ID}&app_key=${APP_KEYS}'

def main():
    print("Find new recipe? (yes/no):")
    command = input("\t>> ")
    print()
    if command.lower() == 'yes':
        search_recipes()


def search_recipes():
    response = None
    success = False
    index = 0
    while not success:
        print('enter a keyword')
        key_word = input("\t>> ")
        data = make_request(get_url_q(key_word))
        data = data['hits']
        if len(data)>0:
            success = True
        else:
            print(f'no results for "{key_word}"')
            input("")
    index = display_recipe_labels(data, index)
    print(f"    select recipe number (1-{index})\n (enter 'm' to see more)")
    select = select_from_index(index)
    if select=='m' and index==10:
        _from = 10
        _to = 20
        data2 = make_request(get_url_q(key_word, _from, _to))
        data2 = data2['hits']
        index = display_recipe_labels(data2, index)
        data += data2
        select = -1
    select_recipe(data, index, select)

def select_recipe(data, max_index, select):
    invalid = True
    while invalid:
        if select == -1:
            select = select_recipe_from_index(max_index)
        if select == 'm':
            display_recipe_labels(data, 0)
            select = select_recipe_from_index(max_index)
        if select == 'q':
            print()
            return
        try:
            select = int(select)
            invalid = False
        except ValueError:
            invalid = True
            select = -1

        recipe_response = data[select]
        recipe = recipe_response['recipe']
        curr_recipe = filter_response(recipe)
        display_recipe_dict(curr_recipe)

def make_request(url):
    response = requests.get(url)
    data = response.json()
    return data

def get_url_q(key_word, _from=0, _to=10):
    url = URL + f'&q=${key_word}&to={_to}&from={_from}'
    return url

def display_recipe_labels(data, index):
    print()
    for recipe in data:
        index += 1
        print(f"    {index})", recipe['recipe']['label'])
    print()
    return index

def select_recipe_from_index(max_index):
    print(f"    Select recipe number (1-{max_index})")
    return select_from_index(max_index)

def select_from_index(max_index):
    select = -1
    while select <=0 or select > max_index:
        select = input("\t>> ")
        if select.lower() == 'q':
            return 'q'
        elif select.lower() =='m':
            return 'm'
        try:
            select = int(select)
        except ValueError as e:
            print("Input must be an integer!")
            select = -1
    return select-1


def filter_response(recipe):
    """
    Takes response object and returns dictionary with readable 
    recipe data
    """
    curr_recipe = {
        "ingredients_line" : recipe["ingredientLines"],
        "ingredients" : recipe["ingredients"],
        "label" : recipe["label"],
        "url" : recipe["url"],
        "uri" : recipe["uri"]}
    return curr_recipe

def display_recipe_dict(curr_recipe):
    """
    Displays dictionary curr_recipe.
    Dictionary curr_recipe keys include: 
        - "ingredients_line"
        - "ingredients"
        - "label"
        - "url"
    """
    print()
    print("====================================================")
    print(f"{curr_recipe['label']}:")
    print("----------------------------------------------------")
    for line in curr_recipe["ingredients_line"]:
        print(f"    - {line}")
    print()
    print(f"Directions: {curr_recipe['url']}")
    print("====================================================")
    input()

if __name__ == "__main__":
    main()

