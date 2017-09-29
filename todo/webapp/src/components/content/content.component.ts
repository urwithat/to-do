import { Component, OnInit } from '@angular/core';

import { TaskService } from '../../providers/task.service';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {

  tasks: any[];
  statuses = [
    {'key': 'COMPLETED', 'value': 'Completed'},
    {'key': 'INPROGRESS', 'value': 'Inprogress'},
    {'key': 'PENDING', 'value': 'Pending'},
    {'key': 'ONHOLD', 'value': 'On Hold'}
  ];

  constructor(public taskService: TaskService) {
    taskService.taskUpdatedEvent.subscribe(
      (tasks) => {
        this.tasks = tasks;
      }
    );
  }

  ngOnInit() {
    this.getTasks();
  }

  getTasks() {
    this.taskService.readAll()
      .subscribe(
        data => {
          this.tasks = data;
        },
        err => this.tasks = err, () => { }
      );
  }

  deleteTask(id) {
    this.taskService.delete(id)
      .subscribe(
        data => {
          this.tasks = data;
        },
        err => this.tasks = err, () => { }
      );
  }

  updateStatus(id, status) {
    console.log(status);
    this.taskService.updateStatus(id, status.toString())
      .subscribe(
        data => {
          this.tasks = data;
        },
        err => this.tasks = err, () => { }
      );
  }

}
