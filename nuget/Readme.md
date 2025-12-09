APIVerve.API.Exercises API
============

Exercises is a simple tool for getting exercise information. It returns information on various exercises.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)

This is a .NET Wrapper for the [APIVerve.API.Exercises API](https://apiverve.com/marketplace/exercises)

---

## Installation

Using the .NET CLI:
```
dotnet add package APIVerve.API.Exercises
```

Using the Package Manager:
```
nuget install APIVerve.API.Exercises
```

Using the Package Manager Console:
```
Install-Package APIVerve.API.Exercises
```

From within Visual Studio:

1. Open the Solution Explorer
2. Right-click on a project within your solution
3. Click on Manage NuGet Packages
4. Click on the Browse tab and search for "APIVerve.API.Exercises"
5. Click on the APIVerve.API.Exercises package, select the appropriate version in the right-tab and click Install

---

## Configuration

Before using the exercises API client, you have to setup your account and obtain your API Key.
You can get it by signing up at [https://apiverve.com](https://apiverve.com)

---

## Quick Start

Here's a simple example to get you started quickly:

```csharp
using System;
using APIVerve;

class Program
{
    static async Task Main(string[] args)
    {
        // Initialize the API client
        var apiClient = new ExercisesAPIClient("[YOUR_API_KEY]");

        var queryOptions = new ExercisesQueryOptions {
  muscle = "chest",
  name = "barbell",
  equipment = "barbell"
};

        // Make the API call
        try
        {
            var response = await apiClient.ExecuteAsync(queryOptions);

            if (response.Error != null)
            {
                Console.WriteLine($"API Error: {response.Error}");
            }
            else
            {
                Console.WriteLine("Success!");
                // Access response data using the strongly-typed ResponseObj properties
                Console.WriteLine(Newtonsoft.Json.JsonConvert.SerializeObject(response, Newtonsoft.Json.Formatting.Indented));
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Exception: {ex.Message}");
        }
    }
}
```

---

## Usage

The APIVerve.API.Exercises API documentation is found here: [https://docs.apiverve.com/ref/exercises](https://docs.apiverve.com/ref/exercises).
You can find parameters, example responses, and status codes documented here.

### Setup

###### Authentication
APIVerve.API.Exercises API uses API Key-based authentication. When you create an instance of the API client, you can pass your API Key as a parameter.

```csharp
// Create an instance of the API client
var apiClient = new ExercisesAPIClient("[YOUR_API_KEY]");
```

---

## Usage Examples

### Basic Usage (Async/Await Pattern - Recommended)

The modern async/await pattern provides the best performance and code readability:

```csharp
using System;
using System.Threading.Tasks;
using APIVerve;

public class Example
{
    public static async Task Main(string[] args)
    {
        var apiClient = new ExercisesAPIClient("[YOUR_API_KEY]");

        var queryOptions = new ExercisesQueryOptions {
  muscle = "chest",
  name = "barbell",
  equipment = "barbell"
};

        var response = await apiClient.ExecuteAsync(queryOptions);

        if (response.Error != null)
        {
            Console.WriteLine($"Error: {response.Error}");
        }
        else
        {
            Console.WriteLine(Newtonsoft.Json.JsonConvert.SerializeObject(response, Newtonsoft.Json.Formatting.Indented));
        }
    }
}
```

### Synchronous Usage

If you need to use synchronous code, you can use the `Execute` method:

```csharp
using System;
using APIVerve;

public class Example
{
    public static void Main(string[] args)
    {
        var apiClient = new ExercisesAPIClient("[YOUR_API_KEY]");

        var queryOptions = new ExercisesQueryOptions {
  muscle = "chest",
  name = "barbell",
  equipment = "barbell"
};

        var response = apiClient.Execute(queryOptions);

        if (response.Error != null)
        {
            Console.WriteLine($"Error: {response.Error}");
        }
        else
        {
            Console.WriteLine(Newtonsoft.Json.JsonConvert.SerializeObject(response, Newtonsoft.Json.Formatting.Indented));
        }
    }
}
```

---

## Error Handling

The API client provides comprehensive error handling. Here are some examples:

### Handling API Errors

```csharp
using System;
using System.Threading.Tasks;
using APIVerve;

public class Example
{
    public static async Task Main(string[] args)
    {
        var apiClient = new ExercisesAPIClient("[YOUR_API_KEY]");

        var queryOptions = new ExercisesQueryOptions {
  muscle = "chest",
  name = "barbell",
  equipment = "barbell"
};

        try
        {
            var response = await apiClient.ExecuteAsync(queryOptions);

            // Check for API-level errors
            if (response.Error != null)
            {
                Console.WriteLine($"API Error: {response.Error}");
                Console.WriteLine($"Status: {response.Status}");
                return;
            }

            // Success - use the data
            Console.WriteLine("Request successful!");
            Console.WriteLine(Newtonsoft.Json.JsonConvert.SerializeObject(response, Newtonsoft.Json.Formatting.Indented));
        }
        catch (ArgumentException ex)
        {
            // Invalid API key or parameters
            Console.WriteLine($"Invalid argument: {ex.Message}");
        }
        catch (System.Net.Http.HttpRequestException ex)
        {
            // Network or HTTP errors
            Console.WriteLine($"Network error: {ex.Message}");
        }
        catch (Exception ex)
        {
            // Other errors
            Console.WriteLine($"Unexpected error: {ex.Message}");
        }
    }
}
```

### Comprehensive Error Handling with Retry Logic

```csharp
using System;
using System.Threading.Tasks;
using APIVerve;

public class Example
{
    public static async Task Main(string[] args)
    {
        var apiClient = new ExercisesAPIClient("[YOUR_API_KEY]");

        // Configure retry behavior (max 3 retries)
        apiClient.SetMaxRetries(3);        // Retry up to 3 times (default: 0, max: 3)
        apiClient.SetRetryDelay(2000);     // Wait 2 seconds between retries

        var queryOptions = new ExercisesQueryOptions {
  muscle = "chest",
  name = "barbell",
  equipment = "barbell"
};

        try
        {
            var response = await apiClient.ExecuteAsync(queryOptions);

            if (response.Error != null)
            {
                Console.WriteLine($"API Error: {response.Error}");
            }
            else
            {
                Console.WriteLine("Success!");
                Console.WriteLine(Newtonsoft.Json.JsonConvert.SerializeObject(response, Newtonsoft.Json.Formatting.Indented));
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Failed after retries: {ex.Message}");
        }
    }
}
```

---

## Advanced Features

### Custom Headers

Add custom headers to your requests:

```csharp
var apiClient = new ExercisesAPIClient("[YOUR_API_KEY]");

// Add custom headers
apiClient.AddCustomHeader("X-Custom-Header", "custom-value");
apiClient.AddCustomHeader("X-Request-ID", Guid.NewGuid().ToString());

var queryOptions = new ExercisesQueryOptions {
  muscle = "chest",
  name = "barbell",
  equipment = "barbell"
};

var response = await apiClient.ExecuteAsync(queryOptions);

// Remove a header
apiClient.RemoveCustomHeader("X-Custom-Header");

// Clear all custom headers
apiClient.ClearCustomHeaders();
```

### Request Logging

Enable logging for debugging:

```csharp
var apiClient = new ExercisesAPIClient("[YOUR_API_KEY]", isDebug: true);

// Or use a custom logger
apiClient.SetLogger(message =>
{
    Console.WriteLine($"[LOG] {DateTime.Now:yyyy-MM-dd HH:mm:ss} - {message}");
});

var queryOptions = new ExercisesQueryOptions {
  muscle = "chest",
  name = "barbell",
  equipment = "barbell"
};

var response = await apiClient.ExecuteAsync(queryOptions);
```

### Retry Configuration

Customize retry behavior for failed requests:

```csharp
var apiClient = new ExercisesAPIClient("[YOUR_API_KEY]");

// Set retry options
apiClient.SetMaxRetries(3);           // Retry up to 3 times (default: 0, max: 3)
apiClient.SetRetryDelay(1500);        // Wait 1.5 seconds between retries (default: 1000ms)

var queryOptions = new ExercisesQueryOptions {
  muscle = "chest",
  name = "barbell",
  equipment = "barbell"
};

var response = await apiClient.ExecuteAsync(queryOptions);
```

### Dispose Pattern

The API client implements `IDisposable` for proper resource cleanup:

```csharp
using (var apiClient = new ExercisesAPIClient("[YOUR_API_KEY]"))
{
    var queryOptions = new ExercisesQueryOptions {
  muscle = "chest",
  name = "barbell",
  equipment = "barbell"
};
    var response = await apiClient.ExecuteAsync(queryOptions);
    Console.WriteLine(Newtonsoft.Json.JsonConvert.SerializeObject(response, Newtonsoft.Json.Formatting.Indented));
}
// HttpClient is automatically disposed here
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
