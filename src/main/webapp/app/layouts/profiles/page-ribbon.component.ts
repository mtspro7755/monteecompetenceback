import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import SharedModule from 'app/shared/shared.module';
import { ProfileService } from './profile.service';

@Component({
  standalone: true,
  selector: 'm-2-gdil-page-ribbon',
  template: `
    @if (ribbonEnv$ | async; as ribbonEnv) {
      <div class="ribbon">
        <a href="" m2GdilTranslate="global.ribbon.{{ ribbonEnv }}">{{ { dev: 'Développement' }[ribbonEnv] || '' }}</a>
      </div>
    }
  `,
  styleUrl: './page-ribbon.component.scss',
  imports: [SharedModule],
})
export default class PageRibbonComponent implements OnInit {
  ribbonEnv$?: Observable<string | undefined>;

  constructor(private profileService: ProfileService) {}

  ngOnInit(): void {
    this.ribbonEnv$ = this.profileService.getProfileInfo().pipe(map(profileInfo => profileInfo.ribbonEnv));
  }
}
