# Exercises API

Exercises is a simple tool for getting exercise information. It returns information on various exercises.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)

This is a Javascript Wrapper for the [Exercises API](https://apiverve.com/marketplace/exercises)

---

## Installation

Using npm:
```shell
npm install @apiverve/exercises
```

Using yarn:
```shell
yarn add @apiverve/exercises
```

---

## Configuration

Before using the Exercises API client, you have to setup your account and obtain your API Key.
You can get it by signing up at [https://apiverve.com](https://apiverve.com)

---

## Quick Start

[Get started with the Quick Start Guide](https://docs.apiverve.com/quickstart)

The Exercises API documentation is found here: [https://docs.apiverve.com/ref/exercises](https://docs.apiverve.com/ref/exercises).
You can find parameters, example responses, and status codes documented here.

### Setup

```javascript
const exercisesAPI = require('@apiverve/exercises');
const api = new exercisesAPI({
    api_key: '[YOUR_API_KEY]'
});
```

---

## Usage

---

### Perform Request

Using the API is simple. All you have to do is make a request. The API will return a response with the data you requested.

```javascript
var query = {
  muscle: "chest",
  name: "barbell",
  equipment: "barbell"
};

api.execute(query, function (error, data) {
    if (error) {
        return console.error(error);
    } else {
        console.log(data);
    }
});
```

---

### Using Promises

You can also use promises to make requests. The API returns a promise that you can use to handle the response.

```javascript
var query = {
  muscle: "chest",
  name: "barbell",
  equipment: "barbell"
};

api.execute(query)
    .then(data => {
        console.log(data);
    })
    .catch(error => {
        console.error(error);
    });
```

---

### Using Async/Await

You can also use async/await to make requests. The API returns a promise that you can use to handle the response.

```javascript
async function makeRequest() {
    var query = {
  muscle: "chest",
  name: "barbell",
  equipment: "barbell"
};

    try {
        const data = await api.execute(query);
        console.log(data);
    } catch (error) {
        console.error(error);
    }
}
```

---

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "count": 5,
    "filteredOn": [
      "name",
      "muscle"
    ],
    "exercises": [
      {
        "name": "Barbell Ab Rollout",
        "force": "pull",
        "level": "intermediate",
        "mechanic": "compound",
        "equipment": "barbell",
        "instructions": [
          "For this exercise you will need to get into a pushup position, but instead of having your hands of the floor, you will be grabbing on to an Olympic barbell (loaded with 5-10 lbs on each side) instead. This will be your starting position.",
          "While keeping a slight arch on your back, lift your hips and roll the barbell towards your feet as you exhale. Tip: As you perform the movement, your glutes should be coming up, you should be keeping the abs tight and should maintain your back posture at all times. Also your arms should be staying perpendicular to the floor throughout the movement. If you don't, you will work out your shoulders and back more than the abs.",
          "After a second contraction at the top, start to roll the barbell back forward to the starting position slowly as you inhale.",
          "Repeat for the recommended amount of repetitions."
        ],
        "muscle": "biceps"
      },
      {
        "name": "Barbell Ab Rollout - On Knees",
        "force": "pull",
        "level": "expert",
        "mechanic": "compound",
        "equipment": "barbell",
        "instructions": [
          "Hold an Olympic barbell loaded with 5-10lbs on each side and kneel on the floor.",
          "Now place the barbell on the floor in front of you so that you are on all your hands and knees (as in a kneeling push up position). This will be your starting position.",
          "Slowly roll the barbell straight forward, stretching your body into a straight position. Tip: Go down as far as you can without touching the floor with your body. Breathe in during this portion of the movement.",
          "After a second pause at the stretched position, start pulling yourself back to the starting position as you breathe out. Tip: Go slowly and keep your abs tight at all times."
        ],
        "muscle": "biceps"
      },
      {
        "name": "Barbell Bench Press - Medium Grip",
        "force": "push",
        "level": "beginner",
        "mechanic": "compound",
        "equipment": "barbell",
        "instructions": [
          "Lie back on a flat bench. Using a medium width grip (a grip that creates a 90-degree angle in the middle of the movement between the forearms and the upper arms), lift the bar from the rack and hold it straight over you with your arms locked. This will be your starting position.",
          "From the starting position, breathe in and begin coming down slowly until the bar touches your middle chest.",
          "After a brief pause, push the bar back to the starting position as you breathe out. Focus on pushing the bar using your chest muscles. Lock your arms and squeeze your chest in the contracted position at the top of the motion, hold for a second and then start coming down slowly again. Tip: Ideally, lowering the weight should take about twice as long as raising it.",
          "Repeat the movement for the prescribed amount of repetitions.",
          "When you are done, place the bar back in the rack."
        ],
        "muscle": "biceps"
      },
      {
        "name": "Barbell Curl",
        "force": "pull",
        "level": "beginner",
        "mechanic": "isolation",
        "equipment": "barbell",
        "instructions": [
          "Stand up with your torso upright while holding a barbell at a shoulder-width grip. The palm of your hands should be facing forward and the elbows should be close to the torso. This will be your starting position.",
          "While holding the upper arms stationary, curl the weights forward while contracting the biceps as you breathe out. Tip: Only the forearms should move.",
          "Continue the movement until your biceps are fully contracted and the bar is at shoulder level. Hold the contracted position for a second and squeeze the biceps hard.",
          "Slowly begin to bring the bar back to starting position as your breathe in.",
          "Repeat for the recommended amount of repetitions."
        ],
        "muscle": "biceps"
      },
      {
        "name": "Barbell Curls Lying Against An Incline",
        "force": "pull",
        "level": "beginner",
        "mechanic": "isolation",
        "equipment": "barbell",
        "instructions": [
          "Lie against an incline bench, with your arms holding a barbell and hanging down in a horizontal line. This will be your starting position.",
          "While keeping the upper arms stationary, curl the weight up as high as you can while squeezing the biceps. Breathe out as you perform this portion of the movement. Tip: Only the forearms should move. Do not swing the arms.",
          "After a second contraction, slowly go back to the starting position as you inhale. Tip: Make sure that you go all of the way down.",
          "Repeat for the recommended amount of repetitions."
        ],
        "muscle": "biceps"
      }
    ]
  }
}
```

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact).

---

## Updates

Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms) and all legal documents and agreements.

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2025 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
