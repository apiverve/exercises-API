declare module '@apiverve/exercises' {
  export interface exercisesOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface exercisesResponse {
    status: string;
    error: string | null;
    data: ExercisesData;
    code?: number;
  }


  interface ExercisesData {
      count:      number;
      filteredOn: string[];
      exercises:  Exercise[];
  }
  
  interface Exercise {
      name:         string;
      force:        string;
      level:        string;
      mechanic:     string;
      equipment:    string;
      instructions: string[];
      muscle:       string;
  }

  export default class exercisesWrapper {
    constructor(options: exercisesOptions);

    execute(callback: (error: any, data: exercisesResponse | null) => void): Promise<exercisesResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: exercisesResponse | null) => void): Promise<exercisesResponse>;
    execute(query?: Record<string, any>): Promise<exercisesResponse>;
  }
}
