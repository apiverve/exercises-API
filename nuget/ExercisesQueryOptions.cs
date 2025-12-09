using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.Exercises
{
    /// <summary>
    /// Query options for the Exercises API
    /// </summary>
    public class ExercisesQueryOptions
    {
        /// <summary>
        /// The muscle group to get exercises for
        /// Example: chest
        /// </summary>
        [JsonProperty("muscle")]
        public string Muscle { get; set; }

        /// <summary>
        /// The name of the exercise to get information about
        /// Example: barbell
        /// </summary>
        [JsonProperty("name")]
        public string Name { get; set; }

        /// <summary>
        /// The equipment used for the exercise
        /// Example: barbell
        /// </summary>
        [JsonProperty("equipment")]
        public string Equipment { get; set; }
    }
}
